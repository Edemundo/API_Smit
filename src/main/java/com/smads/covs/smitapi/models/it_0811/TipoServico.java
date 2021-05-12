package com.smads.covs.smitapi.models.it_0811;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_servico")
public class TipoServico {

  @Id
  private Integer cdTipoServico;
  private String dcTipoServico;

  public TipoServico() {
  }

  public Integer getCdTipoServico() {
    return cdTipoServico;
  }

  public void setCdTipoServico(Integer cdTipoServico) {
    this.cdTipoServico = cdTipoServico;
  }

  public String getDcTipoServico() {
    return dcTipoServico;
  }

  public void setDcTipoServico(String dcTipoServico) {
    this.dcTipoServico = dcTipoServico;
  }

  @Override
  public String toString() {
    return "TipoServico{" +
      "cdTipoServico=" + cdTipoServico +
      ", dcTipoServico='" + dcTipoServico + '\'' +
      '}';
  }
}
