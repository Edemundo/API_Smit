package com.smads.covs.trajetoria_cidadao.models.sisa_sicr_sisrua;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

@Entity
public class DimTipoProvidencia implements Serializable {

    private Integer ciTipoProvidencia;
    private String dcTipoProvidencia;
    private Integer ciAtivoInativo;
    private Integer ciUsuario;
    private Integer inProvidenciaAtendimento;
    private Date dtCarga;
    private String origemDado;

    public DimTipoProvidencia() {
    }

    public DimTipoProvidencia(Integer ciTipoProvidencia) {
        this.ciTipoProvidencia = ciTipoProvidencia;
    }

    public DimTipoProvidencia(String dcTipoProvidencia, Integer ciAtivoInativo, Integer ciUsuario, Integer inProvidenciaAtendimento, Date dtCarga, String origemDado) {
        this.dcTipoProvidencia = dcTipoProvidencia;
        this.ciAtivoInativo = ciAtivoInativo;
        this.ciUsuario = ciUsuario;
        this.inProvidenciaAtendimento = inProvidenciaAtendimento;
        this.dtCarga = dtCarga;
        this.origemDado = origemDado;
    }

    public Integer getCiTipoProvidencia() {
        return ciTipoProvidencia;
    }

    public void setCiTipoProvidencia(Integer ciTipoProvidencia) {
        this.ciTipoProvidencia = ciTipoProvidencia;
    }

    public String getDcTipoProvidencia() {
        return dcTipoProvidencia;
    }

    public void setDcTipoProvidencia(String dcTipoProvidencia) {
        this.dcTipoProvidencia = dcTipoProvidencia;
    }

    public Integer getCiAtivoInativo() {
        return ciAtivoInativo;
    }

    public void setCiAtivoInativo(Integer ciAtivoInativo) {
        this.ciAtivoInativo = ciAtivoInativo;
    }

    public Integer getCiUsuario() {
        return ciUsuario;
    }

    public void setCiUsuario(Integer ciUsuario) {
        this.ciUsuario = ciUsuario;
    }

    public Integer getInProvidenciaAtendimento() {
        return inProvidenciaAtendimento;
    }

    public void setInProvidenciaAtendimento(Integer inProvidenciaAtendimento) {
        this.inProvidenciaAtendimento = inProvidenciaAtendimento;
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
        return "DimTipoProvidencia{" +
                "ciTipoProvidencia=" + ciTipoProvidencia +
                ", dcTipoProvidencia='" + dcTipoProvidencia + '\'' +
                ", ciAtivoInativo=" + ciAtivoInativo +
                ", ciUsuario=" + ciUsuario +
                ", inProvidenciaAtendimento=" + inProvidenciaAtendimento +
                ", dtCarga=" + dtCarga +
                ", origemDado='" + origemDado + '\'' +
                '}';
    }
}
