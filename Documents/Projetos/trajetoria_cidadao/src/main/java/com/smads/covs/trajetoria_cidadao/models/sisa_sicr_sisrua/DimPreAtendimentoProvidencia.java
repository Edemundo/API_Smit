package com.smads.covs.trajetoria_cidadao.models.sisa_sicr_sisrua;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class DimPreAtendimentoProvidencia {

    @Id
    private Integer ciPreAtendimentoProvidencia;
    private Integer ciPreAtendimento;
    private Integer ciTipoAtendimento;
    private Date dtCarga;
    private String origemDado;

    public DimPreAtendimentoProvidencia() {
    }

    public DimPreAtendimentoProvidencia(Integer ciPreAtendimentoProvidencia) {
        this.ciPreAtendimentoProvidencia = ciPreAtendimentoProvidencia;
    }

    public DimPreAtendimentoProvidencia(Integer ciPreAtendimento, Integer ciTipoAtendimento, Date dtCarga, String origemDado) {
        this.ciPreAtendimento = ciPreAtendimento;
        this.ciTipoAtendimento = ciTipoAtendimento;
        this.dtCarga = dtCarga;
        this.origemDado = origemDado;
    }

    public Integer getCiPreAtendimentoProvidencia() {
        return ciPreAtendimentoProvidencia;
    }

    public void setCiPreAtendimentoProvidencia(Integer ciPreAtendimentoProvidencia) {
        this.ciPreAtendimentoProvidencia = ciPreAtendimentoProvidencia;
    }

    public Integer getCiPreAtendimento() {
        return ciPreAtendimento;
    }

    public void setCiPreAtendimento(Integer ciPreAtendimento) {
        this.ciPreAtendimento = ciPreAtendimento;
    }

    public Integer getCiTipoAtendimento() {
        return ciTipoAtendimento;
    }

    public void setCiTipoAtendimento(Integer ciTipoAtendimento) {
        this.ciTipoAtendimento = ciTipoAtendimento;
    }

    public Date getDtCarga() {
        return dtCarga;
    }

    public void setDtCarga(Date dtCarga) {
        this.dtCarga = dtCarga;
    }

    public String getOrigemDado() {
        return origemDado;
    }

    public void setOrigemDado(String origemDado) {
        this.origemDado = origemDado;
    }

    @Override
    public String toString() {
        return "DimPreAtendimentoProvidencia{" +
                "ciPreAtendimentoProvidencia=" + ciPreAtendimentoProvidencia +
                ", ciPreAtendimento=" + ciPreAtendimento +
                ", ciTipoAtendimento=" + ciTipoAtendimento +
                ", dtCarga=" + dtCarga +
                ", origemDado='" + origemDado + '\'' +
                '}';
    }
}
