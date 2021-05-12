package com.smads.covs.smitapi.models.it_0811;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "motivo_procura")
public class MotivoProcura {

  @Id
  private Integer cdMotivoProcura;
  private String dcMotivoProcura;

  public MotivoProcura() {
  }

  public Integer getCdMotivoProcura() {
    return cdMotivoProcura;
  }

  public void setCdMotivoProcura(Integer cdMotivoProcura) {
    this.cdMotivoProcura = cdMotivoProcura;
  }

  public String getDcMotivoProcura() {
    return dcMotivoProcura;
  }

  public void setDcMotivoProcura(String dcMotivoProcura) {
    this.dcMotivoProcura = dcMotivoProcura;
  }

  @Override
  public String toString() {
    return "MotivoProcura{" +
      "cdMotivoProcura=" + cdMotivoProcura +
      ", dcMotivoProcura='" + dcMotivoProcura + '\'' +
      '}';
  }
}
