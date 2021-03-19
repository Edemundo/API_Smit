package com.smads.covs.trajetoria_cidadao.models.sisa_sicr_sisrua;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

@Entity
public class FatPreAtendimento implements Serializable {

    @Id
    private Integer ciPreAtendimento;
    private BigInteger ciCidadao;
    private Date dtPreAtendimento;
    private Integer ciTipoProcura;
    private Integer ciCentroAssistencial;

    public FatPreAtendimento() {
    }

    public FatPreAtendimento(Integer ciPreAtendimento) {
        this.ciPreAtendimento = ciPreAtendimento;
    }

    public FatPreAtendimento(Integer ciPreAtendimento, BigInteger ciCidadao, Date dtPreAtendimento, Integer ciTipoProcura, Integer ciCentroAssistencial) {
        this.ciPreAtendimento = ciPreAtendimento;
        this.ciCidadao = ciCidadao;
        this.dtPreAtendimento = dtPreAtendimento;
        this.ciTipoProcura = ciTipoProcura;
        this.ciCentroAssistencial = ciCentroAssistencial;
    }

    public Integer getCiPreAtendimento() {
        return ciPreAtendimento;
    }

    public void setCiPreAtendimento(Integer ciPreAtendimento) {
        this.ciPreAtendimento = ciPreAtendimento;
    }

    public BigInteger getCiCidadao() {
        return ciCidadao;
    }

    public void setCiCidadao(BigInteger ciCidadao) {
        this.ciCidadao = ciCidadao;
    }

    public Date getDtPreAtendimento() {
        return dtPreAtendimento;
    }

    public void setDtPreAtendimento(Date dtPreAtendimento) {
        this.dtPreAtendimento = dtPreAtendimento;
    }

    public Integer getCiTipoProcura() {
        return ciTipoProcura;
    }

    public void setCiTipoProcura(Integer ciTipoProcura) {
        this.ciTipoProcura = ciTipoProcura;
    }

    public Integer getCiCentroAssistencial() {
        return ciCentroAssistencial;
    }

    public void setCiCentroAssistencial(Integer ciCentroAssistencial) {
        this.ciCentroAssistencial = ciCentroAssistencial;
    }

    @Override
    public String toString() {
        return "FatPreAtendimento{" +
                "ciPreAtendimento=" + ciPreAtendimento +
                ", ciCidadao=" + ciCidadao +
                ", dtPreAtendimento=" + dtPreAtendimento +
                ", ciTipoProcura=" + ciTipoProcura +
                ", ciCentroAssistencial=" + ciCentroAssistencial +
                '}';
    }
}
