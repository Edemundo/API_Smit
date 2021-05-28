package com.smads.covs.smitapi.controllers;

import com.smads.covs.smitapi.models.retorno.PernoiteAgregadoPorServico;
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
import java.util.List;

@Controller
public class SisaPernoiteController {
  private final CloseableHttpClient httpClient = HttpClients.createDefault();

  private final VTrajcidPernoiteBaseReplicadaService vTrajcidPernoiteBaseReplicadaService;
  // private final todas tabelas que serão utilizadas do banco 0811
  private final ServicoService servicoService;
  private final TipoServicoService tipoServicoService;

  private final List<SisaPernoiteData> lstSisaPernoiteData;
  private final List<SisaPernoiteData> lstSisaPernoiteDataAgrServico;
  private final List<SisaPernoiteData> lstSisaPernCompare;
  private final List<PernoiteAgregadoPorServico> lstPernoiteAgregadoPorServicos;


  public SisaPernoiteController(VTrajcidPernoiteBaseReplicadaService vTrajcidPernoiteBaseReplicadaService,
                                ServicoService servicoService, TipoServicoService tipoServicoService, List<SisaPernoiteData> lstSisaPernoiteData,
                                List<SisaPernoiteData> lstSisaPernoiteDataAgrServico, List<PernoiteAgregadoPorServico> lstPernoiteAgregadoPorServicos, List<SisaPernoiteData> lstSisaPernCompare) {
    this.vTrajcidPernoiteBaseReplicadaService = vTrajcidPernoiteBaseReplicadaService;
    this.servicoService = servicoService;
    this.tipoServicoService = tipoServicoService;
    this.lstSisaPernoiteData = lstSisaPernoiteData;
    this.lstSisaPernoiteDataAgrServico = lstSisaPernoiteDataAgrServico;
    this.lstPernoiteAgregadoPorServicos = lstPernoiteAgregadoPorServicos;
    this.lstSisaPernCompare = lstSisaPernCompare;
  }

  public List<PernoiteAgregadoPorServico> SisaPern(BigInteger ciCidadao) throws IOException, URISyntaxException {

    List<VTrajcidPernoiteBaseReplicada> lstVTrajcidPernoiteBaseReplicada = vTrajcidPernoiteBaseReplicadaService.findByVTrajcidPernoiteBaseReplicada(ciCidadao);
    lstSisaPernoiteData.clear();
    for (VTrajcidPernoiteBaseReplicada vTrajcidPernoiteBaseReplicada : lstVTrajcidPernoiteBaseReplicada) {

      SisaPernoiteData sisaPernoiteData = new SisaPernoiteData();

      if(vTrajcidPernoiteBaseReplicada.getDtHospedagem() != null){
        sisaPernoiteData.setDtHospedagem(vTrajcidPernoiteBaseReplicada.getDtHospedagem());
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

    lstSisaPernCompare.clear();
    lstPernoiteAgregadoPorServicos.clear();
    boolean nomeServicoRepetido = false;
    for(int i = 0; i < lstSisaPernoiteData.size(); i++){
      SisaPernoiteData sisaPernoiteDataFor1 = new SisaPernoiteData();
      if(i == 0) {
        sisaPernoiteDataFor1.setNmServico(lstSisaPernoiteData.get(i).getNmServico());
        sisaPernoiteDataFor1.setNmDistrito(lstSisaPernoiteData.get(i).getNmDistrito());
        sisaPernoiteDataFor1.setNmSubprefeitura(lstSisaPernoiteData.get(i).getNmSubprefeitura());
        sisaPernoiteDataFor1.setNmTipoServico(lstSisaPernoiteData.get(i).getNmTipoServico());
        sisaPernoiteDataFor1.setDtHospedagem(lstSisaPernoiteData.get(i).getDtHospedagem());
        lstSisaPernCompare.add(sisaPernoiteDataFor1);
        continue;
      }

      for (SisaPernoiteData sisaPernoiteData : lstSisaPernCompare) {
        if (lstSisaPernoiteData.get(i).getNmServico().equals(sisaPernoiteData.getNmServico())) {
          nomeServicoRepetido = true;
          break;
        }
      }

      if(!nomeServicoRepetido){
        lstSisaPernCompare.add(lstSisaPernoiteData.get(i));
      }
      nomeServicoRepetido = false;
    }

    for (SisaPernoiteData sisaPernoiteData : lstSisaPernCompare) {

      PernoiteAgregadoPorServico pernoiteAgregadoPorServico = new PernoiteAgregadoPorServico();
      lstSisaPernoiteDataAgrServico.clear();
      String nomeComparacao = sisaPernoiteData.getNmServico();
      int qtdEstadias = 0;

      for (SisaPernoiteData lstSisaPernoiteDatum : lstSisaPernoiteData) {
        if (nomeComparacao.equals(lstSisaPernoiteDatum.getNmServico())) {
          if (lstSisaPernoiteDataAgrServico.size() == 0) {
            pernoiteAgregadoPorServico.setNmServico(sisaPernoiteData.getNmServico());
            pernoiteAgregadoPorServico.setNmTipoServico(sisaPernoiteData.getNmTipoServico());
            pernoiteAgregadoPorServico.setNmDistrito(sisaPernoiteData.getNmDistrito());
            pernoiteAgregadoPorServico.setNmSubprefeitura(sisaPernoiteData.getNmSubprefeitura());
            pernoiteAgregadoPorServico.setPrimeiraData(sisaPernoiteData.getDtHospedagem());
            pernoiteAgregadoPorServico.setUltimaData(sisaPernoiteData.getDtHospedagem());
          } else {
            if (pernoiteAgregadoPorServico.getPrimeiraData().compareTo(lstSisaPernoiteDatum.getDtHospedagem()) > 0) {
              pernoiteAgregadoPorServico.setPrimeiraData(lstSisaPernoiteDatum.getDtHospedagem());
            }
            if (pernoiteAgregadoPorServico.getUltimaData().compareTo(lstSisaPernoiteDatum.getDtHospedagem()) < 0) {
              pernoiteAgregadoPorServico.setUltimaData(lstSisaPernoiteDatum.getDtHospedagem());
            }
          }
          pernoiteAgregadoPorServico.setQtdEstadias(qtdEstadias += 1);
          lstSisaPernoiteDataAgrServico.add(lstSisaPernoiteDatum);
        }

      }
      lstPernoiteAgregadoPorServicos.add(pernoiteAgregadoPorServico);
    }

    return lstPernoiteAgregadoPorServicos;
  }
}
