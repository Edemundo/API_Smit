package com.smads.covs.smitapi.models.it_0811;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "servico")
public class Servico {

  @Id
  private Integer cdServico;
  private String nmServico;

  public Servico() {
  }

  public Integer getCdServico() {
    return cdServico;
  }

  public void setCdServico(Integer cdServico) {
    this.cdServico = cdServico;
  }

  public String getNmServico() {
    return nmServico;
  }

  public void setNmServico(String nmServico) {
    this.nmServico = nmServico;
  }

  @Override
  public String toString() {
    return "Servico{" +
      "cdServico=" + cdServico +
      ", nmServico='" + nmServico + '\'' +
      '}';
  }
}
