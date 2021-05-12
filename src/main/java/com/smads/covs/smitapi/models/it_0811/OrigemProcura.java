package com.smads.covs.smitapi.models.it_0811;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "origem_procura")
public class OrigemProcura {

  @Id
  private Integer cdOrigemProcura;
  private String dcOrigemProcura;

  public OrigemProcura() {
  }

  public Integer getCdOrigemProcura() {
    return cdOrigemProcura;
  }

  public void setCdOrigemProcura(Integer cdOrigemProcura) {
    this.cdOrigemProcura = cdOrigemProcura;
  }

  public String getDcOrigemProcura() {
    return dcOrigemProcura;
  }

  public void setDcOrigemProcura(String dcOrigemProcura) {
    this.dcOrigemProcura = dcOrigemProcura;
  }

  @Override
  public String toString() {
    return "OrigemProcura{" +
      "cdOrigemProcura=" + cdOrigemProcura +
      ", dcOrigemProcura='" + dcOrigemProcura + '\'' +
      '}';
  }
}
