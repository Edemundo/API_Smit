package com.smads.covs.trajetoria_cidadao.models.sisa_sicr_sisrua;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class DimMotivoProcura implements Serializable {

    @Id
    private Integer ciMotivoProcura;
    private String dcMotivoProcura;
    private Integer ciAtivoInativo;
    private Date dtCarga;
    private String origemDado;

    public DimMotivoProcura() {
    }

    public DimMotivoProcura(Integer ciMotivoProcura) {
        this.ciMotivoProcura = ciMotivoProcura;
    }

    public DimMotivoProcura(Integer ciMotivoProcura, String dcMotivoProcura, Integer ciAtivoInativo, Date dtCarga, String origemDado) {
        this.ciMotivoProcura = ciMotivoProcura;
        this.dcMotivoProcura = dcMotivoProcura;
        this.ciAtivoInativo = ciAtivoInativo;
        this.dtCarga = dtCarga;
        this.origemDado = origemDado;
    }

    public Integer getCiMotivoProcura() {
        return ciMotivoProcura;
    }

    public void setCiMotivoProcura(Integer ciMotivoProcura) {
        this.ciMotivoProcura = ciMotivoProcura;
    }

    public String getDcMotivoProcura() {
        return dcMotivoProcura;
    }

    public void setDcMotivoProcura(String dcMotivoProcura) {
        this.dcMotivoProcura = dcMotivoProcura;
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
        return "DimMotivoProcura{" +
                "ciMotivoProcura=" + ciMotivoProcura +
                ", dcMotivoProcura='" + dcMotivoProcura + '\'' +
                ", ciAtivoInativo=" + ciAtivoInativo +
                ", dtCarga=" + dtCarga +
                ", origemDado='" + origemDado + '\'' +
                '}';
    }
}
