package com.smads.covs.smitapi.controllers;

import com.smads.covs.smitapi.models.retorno.SisaPernoiteData;
import com.smads.covs.smitapi.models.views.VTrajcidPernoiteBaseReplicada;
import com.smads.covs.smitapi.services.it_0811.ServicoService;
import com.smads.covs.smitapi.services.it_0811.TipoServicoService;
import com.smads.covs.smitapi.services.views.VTrajcidPernoiteBaseReplicadaService;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class SisaPernoiteController {

  private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
  private final VTrajcidPernoiteBaseReplicadaService vTrajcidPernoiteBaseReplicadaService;

  // private final todas tabelas que serão utilizadas do banco 0811
  private final ServicoService servicoService;
  private final TipoServicoService tipoServicoService;

  private final CloseableHttpClient httpClient = HttpClients.createDefault();

  private final List<SisaPernoiteData> lstSisaPernoiteData;

  public SisaPernoiteController(VTrajcidPernoiteBaseReplicadaService vTrajcidPernoiteBaseReplicadaService, ServicoService servicoService, TipoServicoService tipoServicoService, List<SisaPernoiteData> lstSisaPernoiteData) {
    this.vTrajcidPernoiteBaseReplicadaService = vTrajcidPernoiteBaseReplicadaService;
    this.servicoService = servicoService;
    this.tipoServicoService = tipoServicoService;
    this.lstSisaPernoiteData = lstSisaPernoiteData;
  }

  public List<SisaPernoiteData> SisaPern(BigInteger ciCidadao) throws IOException, URISyntaxException {

    List<VTrajcidPernoiteBaseReplicada> lstVTrajcidPernoiteBaseReplicada = vTrajcidPernoiteBaseReplicadaService.findByVTrajcidPernoiteBaseReplicada(ciCidadao);
    lstSisaPernoiteData.clear();
    for (VTrajcidPernoiteBaseReplicada vTrajcidPernoiteBaseReplicada : lstVTrajcidPernoiteBaseReplicada) {

      SisaPernoiteData sisaPernoiteData = new SisaPernoiteData();

      if(vTrajcidPernoiteBaseReplicada.getDtHospedagem() != null){
        String strDtDesligamento = formatter.format(vTrajcidPernoiteBaseReplicada.getDtHospedagem());
        sisaPernoiteData.setDtHospedagem(strDtDesligamento);
      }

      String nmServico = servicoService.findServico(vTrajcidPernoiteBaseReplicada.getCdServico()).getNmServico();
      String nmTipoServico = tipoServicoService.findTipoServico(vTrajcidPernoiteBaseReplicada.getCdTipoServico()).getDcTipoServico();

      sisaPernoiteData.setNmServico(nmServico);
      sisaPernoiteData.setNmTipoServico(nmTipoServico);

      // Chamando API do banco it_0101
      HttpGet httpGet = new HttpGet("http://localhost:9091/it0101/sisa");
      URI uri = new URIBuilder(httpGet.getURI())
        .addParameter("nrDistrito", String.valueOf(vTrajcidPernoiteBaseReplicada.getNrDistrito()))
        .addParameter("cdSubprefeitura", String.valueOf(vTrajcidPernoiteBaseReplicada.getCdSubprefeitura()))
        .build();
      httpGet.setURI(uri);
      try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
        HttpEntity entity = response.getEntity();
        if (entity != null) {
          // return it as a String
          String entityString = EntityUtils.toString(entity);

          JSONArray arrDistrSubp = new JSONArray(entityString);
          sisaPernoiteData.setNmDistrito(arrDistrSubp.getString(0));
          sisaPernoiteData.setNmSubprefeitura(arrDistrSubp.getString(1));
        }
      } catch (ClientProtocolException | JSONException e) {
        e.printStackTrace();
      }

      lstSisaPernoiteData.add(sisaPernoiteData);
    }
    return lstSisaPernoiteData;
  }
}
