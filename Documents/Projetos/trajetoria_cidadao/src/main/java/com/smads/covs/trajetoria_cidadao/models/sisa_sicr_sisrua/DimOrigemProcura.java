package com.smads.covs.trajetoria_cidadao.models.sisa_sicr_sisrua;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class DimOrigemProcura implements Serializable {

    @Id
    private Integer cdOrigemProcura;
    private String dcOrigemProcura;
    private Integer inAtivoInativo;
    private Date dtCarga;
    private String origemDado;

    public DimOrigemProcura() {
    }

    public DimOrigemProcura(Integer cdOrigemProcura) {
        this.cdOrigemProcura = cdOrigemProcura;
    }

    public DimOrigemProcura(Integer cdOrigemProcura,
                            String dcOrigemProcura,
                            Integer inAtivoInativo,
                            Date dtCarga,
                            String origemDado) {
        this.cdOrigemProcura = cdOrigemProcura;
        this.dcOrigemProcura = dcOrigemProcura;
        this.inAtivoInativo = inAtivoInativo;
        this.dtCarga = dtCarga;
        this.origemDado = origemDado;
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
        return "DimOrigemProcura{" +
                "cdOrigemProcura=" + cdOrigemProcura +
                ", dcOrigemProcura='" + dcOrigemProcura + '\'' +
                ", inAtivoInativo=" + inAtivoInativo +
                ", dtCarga=" + dtCarga +
                ", origemDado='" + origemDado + '\'' +
                '}';
    }
}
