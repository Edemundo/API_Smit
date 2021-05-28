package com.smads.covs.smitapi.controllers;

import com.smads.covs.smitapi.models.retorno.SisaVinculadoData;
import com.smads.covs.smitapi.models.views.VTrajcidVinculadoBaseReplicada;
import com.smads.covs.smitapi.services.it_0811.*;
import com.smads.covs.smitapi.services.views.VTrajcidVinculadoBaseReplicadaService;
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Controller
public class SisaVinculadoController {

  private final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
  private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

  private final VTrajcidVinculadoBaseReplicadaService vTrajcidVinculadoBaseReplicadaService;

  // private final todos os services das tabelas que serão utilizadas do banco 0811
  private final MotivoDesligamentoService motivoDesligamentoService;
  private final MotivoProcuraService motivoProcuraService;
  private final OrigemProcuraService origemProcuraService;
  private final ServicoService servicoService;
  private final TipoServicoService tipoServicoService;

  private final CloseableHttpClient httpClient = HttpClients.createDefault();

  private final List<SisaVinculadoData> lstSisaVinculadoData;
  public SisaVinculadoController(VTrajcidVinculadoBaseReplicadaService vTrajcidVinculadoBaseReplicadaService,
                                 MotivoDesligamentoService motivoDesligamentoService, MotivoProcuraService motivoProcuraService,
                                 OrigemProcuraService origemProcuraService, ServicoService servicoService, TipoServicoService tipoServicoService, List<SisaVinculadoData> lstSisaVinculadoData) {
    this.vTrajcidVinculadoBaseReplicadaService = vTrajcidVinculadoBaseReplicadaService;
    this.motivoDesligamentoService = motivoDesligamentoService;
    this.motivoProcuraService = motivoProcuraService;
    this.origemProcuraService = origemProcuraService;
    this.servicoService = servicoService;
    this.tipoServicoService = tipoServicoService;
    this.lstSisaVinculadoData = lstSisaVinculadoData;
  }

  public List<SisaVinculadoData> SisaVinc(BigInteger ciCidadao) throws URISyntaxException, IOException {

    List<VTrajcidVinculadoBaseReplicada> lstVTrajcidVinculadoBaseReplicada = vTrajcidVinculadoBaseReplicadaService.findAllByVTrajcidVinculadoBaseReplicada(ciCidadao);
    lstSisaVinculadoData.clear();
    for (VTrajcidVinculadoBaseReplicada vTrajcidVinculadoBaseReplicada : lstVTrajcidVinculadoBaseReplicada) {

      SisaVinculadoData sisaVinculadoData = new SisaVinculadoData();

      String strDtDesligamento = null;
      if(vTrajcidVinculadoBaseReplicada.getDtDesligamento() != null){
        strDtDesligamento = formatter.format(vTrajcidVinculadoBaseReplicada.getDtDesligamento());
        sisaVinculadoData.setDtDesligamento(strDtDesligamento);
      }
      else{
        sisaVinculadoData.setDtDesligamento("-");
      }

      String strDtVinculacao = null;
      if(vTrajcidVinculadoBaseReplicada.getDtVinculacao() != null){
        strDtVinculacao = formatter.format(vTrajcidVinculadoBaseReplicada.getDtVinculacao());
        sisaVinculadoData.setDtVinculacao(strDtVinculacao);
      }
      else{
        sisaVinculadoData.setDtVinculacao("-");
      }

      long tempPerm;
      //Calculando o tempo de permanência
      if(strDtDesligamento != null && strDtVinculacao != null){
        LocalDate dateVinc = LocalDate.parse(strDtVinculacao, dtf);
        LocalDate dateDesl = LocalDate.parse(strDtDesligamento, dtf);
        tempPerm = ChronoUnit.DAYS.between(dateVinc,dateDesl);
        sisaVinculadoData.setTempoPermanencia(tempPerm);
      }
      else if(strDtVinculacao != null && strDtDesligamento == null){
        LocalDate dateVinc = LocalDate.parse(strDtVinculacao, dtf);
        LocalDate dateToday = LocalDate.now();
        tempPerm = ChronoUnit.DAYS.between(dateVinc,dateToday);
        sisaVinculadoData.setTempoPermanencia(tempPerm);
      }

      // Chamar aqui os services das tabelas do banco 0811
      Integer cdMotivoDesligamento = vTrajcidVinculadoBaseReplicada.getCdMotivoDesligamento();
      Integer cdMotivoProcura = vTrajcidVinculadoBaseReplicada.getCdMotivoProcura();
      Integer cdOrigemProcura = vTrajcidVinculadoBaseReplicada.getCdOrigemProcura();
      Integer cdServico = vTrajcidVinculadoBaseReplicada.getCdServico();
      Integer cdTipoServico = vTrajcidVinculadoBaseReplicada.getCdTipoServico();

      if(cdMotivoDesligamento != null){
        String motivoDesl = motivoDesligamentoService.findMotivoDesligamento(cdMotivoDesligamento).getDcMotivoDesligamento();
        sisaVinculadoData.setNmMotivoDesligamento(motivoDesl);
      }
      else{
        sisaVinculadoData.setNmMotivoDesligamento("-");
      }
      if(cdMotivoProcura != null){
        String motivProc = motivoProcuraService.findMotivoProcura(cdMotivoProcura).getDcMotivoProcura();
        sisaVinculadoData.setNmMotivoProcura(motivProc);
      }
      else{
        sisaVinculadoData.setNmMotivoProcura("-");
      }
      if(cdOrigemProcura != null){
        String origemProc = origemProcuraService.findOrigemProcura(cdOrigemProcura).getDcOrigemProcura();
        sisaVinculadoData.setNmOrigemProcura(origemProc);
      }
      else{
        sisaVinculadoData.setNmOrigemProcura("-");
      }
      if(cdServico != null){
        String nmServico = servicoService.findServico(cdServico).getNmServico();
        sisaVinculadoData.setNmServico(nmServico);
      }
      else{
        sisaVinculadoData.setNmServico("-");
      }
      if(cdTipoServico != null){
        String nmTipoServico = tipoServicoService.findTipoServico(cdTipoServico).getDcTipoServico();
        sisaVinculadoData.setNmTipoServico(nmTipoServico);
      }
      else{
        sisaVinculadoData.setNmTipoServico("-");
      }

      // Chamando API do banco it_0101
      HttpGet httpGet = new HttpGet("http://localhost:9091/it0101/sisa");
      URI uri = new URIBuilder(httpGet.getURI())
        .addParameter("nrDistrito", String.valueOf(vTrajcidVinculadoBaseReplicada.getNrDistrito()))
        .addParameter("cdSubprefeitura", String.valueOf(vTrajcidVinculadoBaseReplicada.getCdSubprefeitura()))
        .build();
      httpGet.setURI(uri);
      try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
        HttpEntity entity = response.getEntity();
        if (response.getStatusLine().getStatusCode() == 200) {
          // return it as a String
          String entityString = EntityUtils.toString(entity);

          JSONArray arrDistrSubp = new JSONArray(entityString);
          sisaVinculadoData.setNmDistrito(arrDistrSubp.getString(0));
          sisaVinculadoData.setNmSubprefeitura(arrDistrSubp.getString(1));
        }
      } catch (ClientProtocolException | JSONException e) {
        e.printStackTrace();
      }

      lstSisaVinculadoData.add(sisaVinculadoData);
    }

    return lstSisaVinculadoData;
  }
}
