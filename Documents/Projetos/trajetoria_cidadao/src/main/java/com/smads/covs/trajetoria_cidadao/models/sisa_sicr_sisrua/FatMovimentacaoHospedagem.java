package com.smads.covs.trajetoria_cidadao.models.sisa_sicr_sisrua;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

@Entity
public class FatMovimentacaoHospedagem implements Serializable {

    @Id
    private Integer cdMovimentacaoHospedagem;
    private BigInteger ciCidadao;
    private Date dtHospedagem;
    private Integer cdServicoHospedagem;

    public FatMovimentacaoHospedagem() {
    }

    public FatMovimentacaoHospedagem(Integer cdMovimentacaoHospedagem) {
        this.cdMovimentacaoHospedagem = cdMovimentacaoHospedagem;
    }

    public FatMovimentacaoHospedagem(Integer cdMovimentacaoHospedagem, BigInteger ciCidadao, Date dtHospedagem, Integer cdServicoHospedagem) {
        this.cdMovimentacaoHospedagem = cdMovimentacaoHospedagem;
        this.ciCidadao = ciCidadao;
        this.dtHospedagem = dtHospedagem;
        this.cdServicoHospedagem = cdServicoHospedagem;
    }

    public Integer getCdMovimentacaoHospedagem() {
        return cdMovimentacaoHospedagem;
    }

    public void setCdMovimentacaoHospedagem(Integer cdMovimentacaoHospedagem) {
        this.cdMovimentacaoHospedagem = cdMovimentacaoHospedagem;
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

    public Integer getCdServicoHospedagem() {
        return cdServicoHospedagem;
    }

    public void setCdServicoHospedagem(Integer cdServicoHospedagem) {
        this.cdServicoHospedagem = cdServicoHospedagem;
    }

    @Override
    public String toString() {
        return "FatMovimentacaoHospedagem{" +
                "cdMovimentacaoHospedagem=" + cdMovimentacaoHospedagem +
                ", ciCidadao=" + ciCidadao +
                ", dtHospedagem=" + dtHospedagem +
                ", cdServicoHospedagem=" + cdServicoHospedagem +
                '}';
    }
}
