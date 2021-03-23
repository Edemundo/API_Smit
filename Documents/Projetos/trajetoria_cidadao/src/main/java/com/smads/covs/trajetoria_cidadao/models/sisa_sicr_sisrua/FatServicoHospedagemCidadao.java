package com.smads.covs.trajetoria_cidadao.models.sisa_sicr_sisrua;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

@Entity
public class FatServicoHospedagemCidadao implements Serializable {

    @Id
    private Integer cdServicoHospedagemCidadao;
    private Date dtVinculacao;
    private Date dtDesligamento;

    // Join Collumns
    private BigInteger ciCidadao;
    private Integer cdServicoHospedagem;
    private Integer cdMotivoDesligamento;
    private Integer cdMotivoProcura;
    private Integer cdOrigemProcura;

    public FatServicoHospedagemCidadao() {
    }

    public FatServicoHospedagemCidadao(Integer cdServicoHospedagemCidadao) {
        this.cdServicoHospedagemCidadao = cdServicoHospedagemCidadao;
    }

    public FatServicoHospedagemCidadao(Date dtVinculacao, Date dtDesligamento,
                                       BigInteger ciCidadao, Integer cdServicoHospedagem,
                                       Integer cdMotivoDesligamento, Integer cdMotivoProcura,
                                       Integer cdOrigemProcura) {
        this.dtVinculacao = dtVinculacao;
        this.dtDesligamento = dtDesligamento;
        this.ciCidadao = ciCidadao;
        this.cdServicoHospedagem = cdServicoHospedagem;
        this.cdMotivoDesligamento = cdMotivoDesligamento;
        this.cdMotivoProcura = cdMotivoProcura;
        this.cdOrigemProcura = cdOrigemProcura;
    }

    public FatServicoHospedagemCidadao(Integer cdServicoHospedagemCidadao, Date dtVinculacao,
                                       Date dtDesligamento, BigInteger ciCidadao, Integer cdServicoHospedagem,
                                       Integer cdMotivoDesligamento, Integer cdMotivoProcura,
                                       Integer cdOrigemProcura) {
        this.cdServicoHospedagemCidadao = cdServicoHospedagemCidadao;
        this.dtVinculacao = dtVinculacao;
        this.dtDesligamento = dtDesligamento;
        this.ciCidadao = ciCidadao;
        this.cdServicoHospedagem = cdServicoHospedagem;
        this.cdMotivoDesligamento = cdMotivoDesligamento;
        this.cdMotivoProcura = cdMotivoProcura;
        this.cdOrigemProcura = cdOrigemProcura;
    }

    public Integer getCdServicoHospedagemCidadao() {
        return cdServicoHospedagemCidadao;
    }

    public void setCdServicoHospedagemCidadao(Integer cdServicoHospedagemCidadao) {
        this.cdServicoHospedagemCidadao = cdServicoHospedagemCidadao;
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

    public BigInteger getCiCidadao() {
        return ciCidadao;
    }

    public void setCiCidadao(BigInteger ciCidadao) {
        this.ciCidadao = ciCidadao;
    }

    public Integer getCdServicoHospedagem() {
        return cdServicoHospedagem;
    }

    public void setCdServicoHospedagem(Integer cdServicoHospedagem) {
        this.cdServicoHospedagem = cdServicoHospedagem;
    }

    public Integer getCdMotivoDesligamento() {
        return cdMotivoDesligamento;
    }

    public void setCdMotivoDesligamento(Integer cdMotivoDesligamento) {
        this.cdMotivoDesligamento = cdMotivoDesligamento;
    }

    public Integer getCdMotivoProcura() {
        return cdMotivoProcura;
    }

    public void setCdMotivoProcura(Integer cdMotivoProcura) {
        this.cdMotivoProcura = cdMotivoProcura;
    }

    public Integer getCdOrigemProcura() {
        return cdOrigemProcura;
    }

    public void setCdOrigemProcura(Integer cdOrigemProcura) {
        this.cdOrigemProcura = cdOrigemProcura;
    }

    @Override
    public String toString() {
        return "FatServicoHospedagemCidadao{" +
                "cdServicoHospedagemCidadao=" + cdServicoHospedagemCidadao +
                ", dtVinculacao=" + dtVinculacao +
                ", dtDesligamento=" + dtDesligamento +
                ", ciCidadao=" + ciCidadao +
                ", cdServicoHospedagem=" + cdServicoHospedagem +
                ", cdMotivoDesligamento=" + cdMotivoDesligamento +
                ", cdMotivoProcura=" + cdMotivoProcura +
                ", cdOrigemProcura=" + cdOrigemProcura +
                '}';
    }
}
