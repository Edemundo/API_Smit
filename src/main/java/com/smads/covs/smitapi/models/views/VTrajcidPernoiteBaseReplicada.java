package com.smads.covs.smitapi.models.views;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "v_trajcid_pernoite_base_replicada")
public class VTrajcidPernoiteBaseReplicada {

  private BigInteger ciCidadao;
  @Id
  private Date dtHospedagem;
  private Integer cdSubprefeitura;
  private Integer nrDistrito;
  private Integer cdServico;
  private Integer cdTipoServico;

  public VTrajcidPernoiteBaseReplicada() {
  }

  public BigInteger getCiCidadao() {
    return ciCidadao;
  }

  public void setCiCidadao(BigInteger ciCidadao) {
    this.ciCidadao = ciCidadao;
  }

  public Date getDtHospedagem() {
    return dtHospedagem;
  }

  public void setDtHospedagem(Date dtHospedagem) {
    this.dtHospedagem = dtHospedagem;
  }

  public Integer getCdSubprefeitura() {
    return cdSubprefeitura;
  }

  public void setCdSubprefeitura(Integer cdSubprefeitura) {
    this.cdSubprefeitura = cdSubprefeitura;
  }

  public Integer getNrDistrito() {
    return nrDistrito;
  }

  public void setNrDistrito(Integer nrDistrito) {
    this.nrDistrito = nrDistrito;
  }

  public Integer getCdServico() {
    return cdServico;
  }

  public void setCdServico(Integer cdServico) {
    this.cdServico = cdServico;
  }

  public Integer getCdTipoServico() {
    return cdTipoServico;
  }

  public void setCdTipoServico(Integer cdTipoServico) {
    this.cdTipoServico = cdTipoServico;
  }

  @Override
  public String toString() {
    return "VTrajcidPernoiteBaseReplicada{" +
      "ciCidadao=" + ciCidadao +
      ", dtHospedagem=" + dtHospedagem +
      ", cdSubprefeitura=" + cdSubprefeitura +
      ", nrDistrito=" + nrDistrito +
      ", cdServico=" + cdServico +
      ", cdTipoServico=" + cdTipoServico +
      '}';
  }
}
