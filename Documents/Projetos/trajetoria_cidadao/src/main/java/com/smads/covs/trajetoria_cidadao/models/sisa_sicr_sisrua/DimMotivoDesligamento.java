package com.smads.covs.trajetoria_cidadao.models.sisa_sicr_sisrua;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class DimMotivoDesligamento implements Serializable {

    @Id
    private Integer cdMotivoDesligamento;
    private String dcMotivoDesligamento;
    private Integer inAtivoInativo;
    private Date dtCarga;
    private String origemDado;

    public DimMotivoDesligamento() {
    }

    public DimMotivoDesligamento(Integer cdMotivoDesligamento) {
        this.cdMotivoDesligamento = cdMotivoDesligamento;
    }

    public DimMotivoDesligamento(Integer cdMotivoDesligamento, String dcMotivoDesligamento, Integer inAtivoInativo, Date dtCarga, String origemDado) {
        this.cdMotivoDesligamento = cdMotivoDesligamento;
        this.dcMotivoDesligamento = dcMotivoDesligamento;
        this.inAtivoInativo = inAtivoInativo;
        this.dtCarga = dtCarga;
        this.origemDado = origemDado;
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

    public Integer getInAtivoInativo() {
        return inAtivoInativo;
    }

    public void setInAtivoInativo(Integer inAtivoInativo) {
        this.inAtivoInativo = inAtivoInativo;
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
        return "DimMotivoDesligamento{" +
                "cdMotivoDesligamento=" + cdMotivoDesligamento +
                ", dcMotivoDesligamento='" + dcMotivoDesligamento + '\'' +
                ", inAtivoInativo=" + inAtivoInativo +
                ", dtCarga=" + dtCarga +
                ", origemDado='" + origemDado + '\'' +
                '}';
    }
}
