package com.smads.covs.smitapi.models.retorno;

import java.util.Date;
import java.util.List;

public class PernoiteAgregadoPorServico {

  private List<SisaPernoiteData> lstServicosPernoitados;
  private String nmSubprefeitura;
  private String nmDistrito;
  private String nmServico;
  private String nmTipoServico;
  private Date primeiraData;
  private Date ultimaData;
  private Integer qtdEstadias;

  public PernoiteAgregadoPorServico() {
  }

  public List<SisaPernoiteData> getLstServicosPernoitados() {
    return lstServicosPernoitados;
  }

  public void setLstServicosPernoitados(List<SisaPernoiteData> lstServicosPernoitados) {
    this.lstServicosPernoitados = lstServicosPernoitados;
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

  public String getNmServico() {
    return nmServico;
  }

  public void setNmServico(String nmServico) {
    this.nmServico = nmServico;
  }

  public String getNmTipoServico() {
    return nmTipoServico;
  }

  public void setNmTipoServico(String nmTipoServico) {
    this.nmTipoServico = nmTipoServico;
  }

  public Date getPrimeiraData() {
    return primeiraData;
  }

  public void setPrimeiraData(Date primeiraData) {
    this.primeiraData = primeiraData;
  }

  public Date getUltimaData() {
    return ultimaData;
  }

  public void setUltimaData(Date ultimaData) {
    this.ultimaData = ultimaData;
  }

  public Integer getQtdEstadias() {
    return qtdEstadias;
  }

  public void setQtdEstadias(Integer qtdEstadias) {
    this.qtdEstadias = qtdEstadias;
  }

  @Override
  public String toString() {
    return "PernoiteAgregadoPorServico{" +
      "lstServicosPernoitados=" + lstServicosPernoitados +
      ", nmSubprefeitura='" + nmSubprefeitura + '\'' +
      ", nmDistrito='" + nmDistrito + '\'' +
      ", nmServico='" + nmServico + '\'' +
      ", nmTipoServico='" + nmTipoServico + '\'' +
      ", primeiraData=" + primeiraData +
      ", ultimaData=" + ultimaData +
      ", qtdEstadias=" + qtdEstadias +
      '}';
  }
}
