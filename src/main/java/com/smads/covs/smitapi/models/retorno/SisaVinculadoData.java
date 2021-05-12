package com.smads.covs.smitapi.models.retorno;

import java.util.Date;

public class SisaVinculadoData {

  private String nmServico;
  private String nmSubprefeitura;
  private String nmDistrito;
  private String nmTipoServico;
  private String dtVinculacao;
  private String dtDesligamento;
  private String nmOrigemProcura;
  private String nmMotivoProcura;
  private String nmMotivoDeligamento;

  public SisaVinculadoData() {
  }

  public String getNmServico() {
    return nmServico;
  }

  public void setNmServico(String nmServico) {
    this.nmServico = nmServico;
  }

  public String getNmSubprefeitura() {
    return nmSubprefeitura;
  }

  public void setNmSubprefeitura(String nmSubprefeitura) {
    this.nmSubprefeitura = nmSubprefeitura;
  }

  public String getNmDistrito() {
    return nmDistrito;
  }

  public void setNmDistrito(String nmDistrito) {
    this.nmDistrito = nmDistrito;
  }

  public String getNmTipoServico() {
    return nmTipoServico;
  }

  public void setNmTipoServico(String nmTipoServico) {
    this.nmTipoServico = nmTipoServico;
  }

  public String getDtVinculacao() {
    return dtVinculacao;
  }

  public void setDtVinculacao(String dtVinculacao) {
    this.dtVinculacao = dtVinculacao;
  }

  public String getDtDesligamento() {
    return dtDesligamento;
  }

  public void setDtDesligamento(String dtDesligamento) {
    this.dtDesligamento = dtDesligamento;
  }

  public String getNmOrigemProcura() {
    return nmOrigemProcura;
  }

  public void setNmOrigemProcura(String nmOrigemProcura) {
    this.nmOrigemProcura = nmOrigemProcura;
  }

  public String getNmMotivoProcura() {
    return nmMotivoProcura;
  }

  public void setNmMotivoProcura(String nmMotivoProcura) {
    this.nmMotivoProcura = nmMotivoProcura;
  }

  public String getNmMotivoDeligamento() {
    return nmMotivoDeligamento;
  }

  public void setNmMotivoDeligamento(String nmMotivoDeligamento) {
    this.nmMotivoDeligamento = nmMotivoDeligamento;
  }

  @Override
  public String toString() {
    return "SisaVinculadoData{" +
      "nmServico='" + nmServico + '\'' +
      ", nmSubprefeitura='" + nmSubprefeitura + '\'' +
      ", nmDistrito='" + nmDistrito + '\'' +
      ", nmTipoServico='" + nmTipoServico + '\'' +
      ", dtVinculacao=" + dtVinculacao +
      ", dtDesligamento=" + dtDesligamento +
      ", nmOrigemProcura='" + nmOrigemProcura + '\'' +
      ", nmMotivoProcura='" + nmMotivoProcura + '\'' +
      ", nmMotivoDeligamento='" + nmMotivoDeligamento + '\'' +
      '}';
  }
}
