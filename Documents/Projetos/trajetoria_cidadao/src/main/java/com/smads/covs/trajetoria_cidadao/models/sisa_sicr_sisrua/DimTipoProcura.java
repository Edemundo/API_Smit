package com.smads.covs.trajetoria_cidadao.models.sisa_sicr_sisrua;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class DimTipoProcura {

    @Id
    private Integer ciTipoProcura;
    private String dcTipoProcura;
    private Integer ciAtivoInativo;
    private Date dtCarga;
    private String origemDado;

    public DimTipoProcura() {
    }

    public DimTipoProcura(Integer ciTipoProcura) {
        this.ciTipoProcura = ciTipoProcura;
    }

    public DimTipoProcura(String dcTipoProcura, Integer ciAtivoInativo, Date dtCarga, String origemDado) {
        this.dcTipoProcura = dcTipoProcura;
        this.ciAtivoInativo = ciAtivoInativo;
        this.dtCarga = dtCarga;
        this.origemDado = origemDado;
    }

    public Integer getCiTipoProcura() {
        return ciTipoProcura;
    }

    public void setCiTipoProcura(Integer ciTipoProcura) {
        this.ciTipoProcura = ciTipoProcura;
    }

    public String getDcTipoProcura() {
        return dcTipoProcura;
    }

    public void setDcTipoProcura(String dcTipoProcura) {
        this.dcTipoProcura = dcTipoProcura;
    }

    public Integer getCiAtivoInativo() {
        return ciAtivoInativo;
    }

    public void setCiAtivoInativo(Integer ciAtivoInativo) {
        this.ciAtivoInativo = ciAtivoInativo;
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
        return "DimTipoProcura{" +
                "ciTipoProcura=" + ciTipoProcura +
                ", dcTipoProcura='" + dcTipoProcura + '\'' +
                ", ciAtivoInativo=" + ciAtivoInativo +
                ", dtCarga=" + dtCarga +
                ", origemDado='" + origemDado + '\'' +
                '}';
    }
}
