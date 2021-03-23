package com.smads.covs.trajetoria_cidadao.models.sisa_sicr_sisrua;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class DimSubprefeitura {

    @Id
    private Integer cdSubprefeitura;
    private String nmSubprefeitura;

    public DimSubprefeitura() {
    }

    public DimSubprefeitura(Integer cdSubprefeitura) {
        this.cdSubprefeitura = cdSubprefeitura;
    }

    public DimSubprefeitura(Integer cdSubprefeitura, String nmSubprefeitura) {
        this.cdSubprefeitura = cdSubprefeitura;
        this.nmSubprefeitura = nmSubprefeitura;
    }

    public Integer getCdSubprefeitura() {
        return cdSubprefeitura;
    }

    public void setCdSubprefeitura(Integer cdSubprefeitura) {
        this.cdSubprefeitura = cdSubprefeitura;
    }

    public String getNmSubprefeitura() {
        return nmSubprefeitura;
    }

    public void setNmSubprefeitura(String nmSubprefeitura) {
        this.nmSubprefeitura = nmSubprefeitura;
    }

    @Override
    public String toString() {
        return "DimSubprefeitura{" +
                "cdSubprefeitura=" + cdSubprefeitura +
                ", nmSubprefeitura='" + nmSubprefeitura + '\'' +
                '}';
    }
}
