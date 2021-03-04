package com.smads.covs.trajetoria_cidadao.model;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.Optional;

@Entity
public class DimCidadao implements Serializable {

    @Id
    private BigInteger ciCidadao;
    private String nmCidadao;
    private String nmMae;
    private Date dtNasc;
    private BigInteger cdNis;
    private BigInteger nrCpf;

    public DimCidadao() {
    }

    public DimCidadao(BigInteger ciCidadao, String nmCidadao, String nmMae, Date dtNasc, BigInteger cdNis, BigInteger nrCpf) {
        this.ciCidadao = ciCidadao;
        this.nmCidadao = nmCidadao;
        this.nmMae = nmMae;
        this.dtNasc = dtNasc;
        this.cdNis = cdNis;
        this.nrCpf = nrCpf;
    }

    public DimCidadao(String nmCidadao, String nmMae, Date dtNasc, BigInteger cdNis, BigInteger nrCpf) {
        this.nmCidadao = nmCidadao;
        this.nmMae = nmMae;
        this.dtNasc = dtNasc;
        this.cdNis = cdNis;
        this.nrCpf = nrCpf;
    }

    public BigInteger getCiCidadao() {
        return ciCidadao;
    }

    public void setCiCidadao(BigInteger ciCidadao) {
        this.ciCidadao = ciCidadao;
    }

    public String getNmCidadao() {
        return nmCidadao;
    }

    public void setNmCidadao(String nmCidadao) {
        this.nmCidadao = nmCidadao;
    }

    public String getNmMae() {
        return nmMae;
    }

    public void setNmMae(String nmMae) {
        this.nmMae = nmMae;
    }

    public Date getDtNasc() {
        return dtNasc;
    }

    public void setDtNasc(Date dtNasc) {
        this.dtNasc = dtNasc;
    }

    public BigInteger getCdNis() {
        return cdNis;
    }

    public void setCdNis(BigInteger cdNis) {
        this.cdNis = cdNis;
    }

    public BigInteger getNrCpf() {
        return nrCpf;
    }

    public void setNrCpf(BigInteger nrCpf) {
        this.nrCpf = nrCpf;
    }

    @Override
    public String toString() {
        return "DimCidadao{" +
                "ciCidadao=" + ciCidadao +
                ", nmCidadao='" + nmCidadao + '\'' +
                ", nmMae='" + nmMae + '\'' +
                ", dtNasc=" + dtNasc +
                ", cdNis=" + cdNis +
                ", nrCpf=" + nrCpf +
                '}';
    }
}
