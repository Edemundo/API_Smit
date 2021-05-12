package com.smads.covs.smitapi.models.it_0811;

import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "motivo_desligamento")
public class MotivoDesligamento {

  @Id
  private Integer cdMotivoDesligamento;
  private String dcMotivoDesligamento;

  public MotivoDesligamento() {
  }

  public Integer getCdMotivoDesligamento() {
    return cdMotivoDesligamento;
  }

  public void setCdMotivoDesligamento(Integer cdMotivoDesligamento) {
    this.cdMotivoDesligamento = cdMotivoDesligamento;
  }

  public String getDcMotivoDesligamento() {
    return dcMotivoDesligamento;
  }

  public void setDcMotivoDesligamento(String dcMotivoDesligamento) {
    this.dcMotivoDesligamento = dcMotivoDesligamento;
  }

  @Override
  public String toString() {
    return "MotivoDesligamento{" +
      "cdMotivoDesligamento=" + cdMotivoDesligamento +
      ", dcMotivoDesligamento='" + dcMotivoDesligamento + '\'' +
      '}';
  }
}
