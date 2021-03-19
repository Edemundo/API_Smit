package com.smads.covs.trajetoria_cidadao.models.sisa_sicr_sisrua;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class DimTipoServico implements Serializable {

    @Id
    private Integer cdTipoServico;
    private String dcTipoServico;

    public DimTipoServico() {
    }

    public DimTipoServico(Integer cdTipoServico) {
        this.cdTipoServico = cdTipoServico;
    }

    public DimTipoServico(Integer cdTipoServico, String dcTipoServico) {
        this.cdTipoServico = cdTipoServico;
        this.dcTipoServico = dcTipoServico;
    }

    public Integer getCdTipoServico() {
        return cdTipoServico;
    }

    public void setCdTipoServico(Integer cdTipoServico) {
        this.cdTipoServico = cdTipoServico;
    }

    public String getDcTipoServico() {
        return dcTipoServico;
    }

    public void setDcTipoServico(String dcTipoServico) {
        this.dcTipoServico = dcTipoServico;
    }

    @Override
    public String toString() {
        return "DimTipoServico{" +
                "cdTipoServico=" + cdTipoServico +
                ", dcTipoServico='" + dcTipoServico + '\'' +
                '}';
    }
}
