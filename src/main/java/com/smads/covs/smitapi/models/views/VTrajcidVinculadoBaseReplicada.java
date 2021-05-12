package com.smads.covs.smitapi.models.views;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "`v_trajcid_vinculado_base_replicada`")
public class VTrajcidVinculadoBaseReplicada implements Serializable{

  private BigInteger ciCidadao;

  @Id
  private Date dtVinculacao;
  private Date dtDesligamento;
  private Integer cdServico;
  private Integer cdSubprefeitura;
  private Integer nrDistrito;
  private Integer cdTipoServico;
  private Integer cdOrigemProcura;
  private Integer cdMotivoProcura;
  private Integer cdMotivoDesligamento;

  public VTrajcidVinculadoBaseReplicada() {
  }

  public BigInteger getCiCidadao() {
    return ciCidadao;
  }

  public void setCiCidadao(BigInteger ciCidadao) {
    this.ciCidadao = ciCidadao;
  }

  public Date getDtVinculacao() {
    return dtVinculacao;
  }

  public void setDtVinculacao(Date dtVinculacao) {
    this.dtVinculacao = dtVinculacao;
  }

  public Date getDtDesligamento() {
    return dtDesligamento;
  }

  public void setDtDesligamento(Date dtDesligamento) {
    this.dtDesligamento = dtDesligamento;
  }

  public Integer getCdServico() {
    return cdServico;
  }

  public void setCdServico(Integer cdServico) {
    this.cdServico = cdServico;
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

  public Integer getCdTipoServico() {
    return cdTipoServico;
  }

  public void setCdTipoServico(Integer cdTipoServico) {
    this.cdTipoServico = cdTipoServico;
  }

  public Integer getCdOrigemProcura() {
    return cdOrigemProcura;
  }

  public void setCdOrigemProcura(Integer cdOrigemProcura) {
    this.cdOrigemProcura = cdOrigemProcura;
  }

  public Integer getCdMotivoProcura() {
    return cdMotivoProcura;
  }

  public void setCdMotivoProcura(Integer cdMotivoProcura) {
    this.cdMotivoProcura = cdMotivoProcura;
  }

  public Integer getCdMotivoDesligamento() {
    return cdMotivoDesligamento;
  }

  public void setCdMotivoDesligamento(Integer cdMotivoDesligamento) {
    this.cdMotivoDesligamento = cdMotivoDesligamento;
  }

  @Override
  public String toString() {
    return "VTrajcidVinculadoBaseReplicada{" +
      "ciCidadao=" + ciCidadao +
      ", dtVinculacao=" + dtVinculacao +
      ", dtDesligamento=" + dtDesligamento +
      ", cdServico=" + cdServico +
      ", cdSubprefeitura=" + cdSubprefeitura +
      ", nrDistrito=" + nrDistrito +
      ", cdTipoServico=" + cdTipoServico +
      ", cdOrigemProcura=" + cdOrigemProcura +
      ", cdMotivoProcura=" + cdMotivoProcura +
      ", cdMotivoDesligamento=" + cdMotivoDesligamento +
      '}';
  }
}
