package com.smads.covs.trajetoria_cidadao.model;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

@Entity
public class DimCidadao implements Serializable {

    @Id
    private BigInteger ciCidadao;
    private String nmCidadao;
    private String nmMae;
    private Date dtNasc;
    private BigInteger cdNis;
    private BigInteger nrCpf;
    private Integer nrMembrosFamilia;
    private Integer ciTipoSexo;
    private Integer ciRacaObservada;
    private Integer ciPaisOrigem;
    private Date dtObito;
    private Integer ciSitCidadao;
    private Integer tpNacionalidade;
    private Integer cdGrauInstrucao;
    private Integer inCidadaoDesaparecido;
    private Integer inCidadaoVitimaViolencia;
    private Integer inCidadaoNecessitaCuidado;
    private Integer inCidadaoSituacaoRua;

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

    public DimCidadao(BigInteger ciCidadao, String nmCidadao, String nmMae,
                      Date dtNasc, BigInteger cdNis, BigInteger nrCpf,
                      Integer nrMembrosFamilia, Integer ciTipoSexo, Integer ciRacaObservada, Integer ciPaisOrigem,
                      Date dtObito, Integer ciSitCidadao, Integer tpNacionalidade, Integer cdGrauInstrucao,
                      Integer inCidadaoDesaparecido, Integer inCidadaoVitimaViolencia, Integer inCidadaoNecessitaCuidado,
                      Integer inCidadaoSituacaoRua) {
        this.ciCidadao = ciCidadao;
        this.nmCidadao = nmCidadao;
        this.nmMae = nmMae;
        this.dtNasc = dtNasc;
        this.cdNis = cdNis;
        this.nrCpf = nrCpf;
        this.nrMembrosFamilia = nrMembrosFamilia;
        this.ciTipoSexo = ciTipoSexo;
        this.ciRacaObservada = ciRacaObservada;
        this.ciPaisOrigem = ciPaisOrigem;
        this.dtObito = dtObito;
        this.ciSitCidadao = ciSitCidadao;
        this.tpNacionalidade = tpNacionalidade;
        this.cdGrauInstrucao = cdGrauInstrucao;
        this.inCidadaoDesaparecido = inCidadaoDesaparecido;
        this.inCidadaoVitimaViolencia = inCidadaoVitimaViolencia;
        this.inCidadaoNecessitaCuidado = inCidadaoNecessitaCuidado;
        this.inCidadaoSituacaoRua = inCidadaoSituacaoRua;
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

    public Integer getNrMembrosFamilia() {
        return nrMembrosFamilia;
    }

    public void setNrMembrosFamilia(Integer nrMembrosFamilia) {
        this.nrMembrosFamilia = nrMembrosFamilia;
    }

    public Integer getCiTipoSexo() {
        return ciTipoSexo;
    }

    public void setCiTipoSexo(Integer ciTipoSexo) {
        this.ciTipoSexo = ciTipoSexo;
    }

    public Integer getCiRacaObservada() {
        return ciRacaObservada;
    }

    public void setCiRacaObservada(Integer ciRacaObservada) {
        this.ciRacaObservada = ciRacaObservada;
    }

    public Integer getCiPaisOrigem() {
        return ciPaisOrigem;
    }

    public void setCiPaisOrigem(Integer ciPaisOrigem) {
        this.ciPaisOrigem = ciPaisOrigem;
    }

    public Date getDtObito() {
        return dtObito;
    }

    public void setDtObito(Date dtObito) {
        this.dtObito = dtObito;
    }

    public Integer getCiSitCidadao() {
        return ciSitCidadao;
    }

    public void setCiSitCidadao(Integer ciSitCidadao) {
        this.ciSitCidadao = ciSitCidadao;
    }

    public Integer getTpNacionalidade() {
        return tpNacionalidade;
    }

    public void setTpNacionalidade(Integer tpNacionalidade) {
        this.tpNacionalidade = tpNacionalidade;
    }

    public Integer getCdGrauInstrucao() {
        return cdGrauInstrucao;
    }

    public void setCdGrauInstrucao(Integer cdGrauIntrucao) {
        this.cdGrauInstrucao = cdGrauIntrucao;
    }

    public Integer getInCidadaoDesaparecido() {
        return inCidadaoDesaparecido;
    }

    public void setInCidadaoDesaparecido(Integer inCidadaoDesaparecido) {
        this.inCidadaoDesaparecido = inCidadaoDesaparecido;
    }

    public Integer getInCidadaoVitimaViolencia() {
        return inCidadaoVitimaViolencia;
    }

    public void setInCidadaoVitimaViolencia(Integer inCidadaoVitimaViolencia) {
        this.inCidadaoVitimaViolencia = inCidadaoVitimaViolencia;
    }

    public Integer getInCidadaoNecessitaCuidado() {
        return inCidadaoNecessitaCuidado;
    }

    public void setInCidadaoNecessitaCuidado(Integer inCidadaoNecessitaCuidado) {
        this.inCidadaoNecessitaCuidado = inCidadaoNecessitaCuidado;
    }

    public Integer getInCidadaoSituacaoRua() {
        return inCidadaoSituacaoRua;
    }

    public void setInCidadaoSituacaoRua(Integer inCidadaoSituacaoRua) {
        this.inCidadaoSituacaoRua = inCidadaoSituacaoRua;
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
                ", nrMembrosFamilia=" + nrMembrosFamilia +
                ", ciTipoSexo=" + ciTipoSexo +
                ", ciRacaObservada=" + ciRacaObservada +
                ", ciPaisOrigem=" + ciPaisOrigem +
                ", dtObito=" + dtObito +
                ", ciSitCidadao=" + ciSitCidadao +
                ", tpNacionalidade=" + tpNacionalidade +
                ", cdGrauInstrucao=" + cdGrauInstrucao +
                ", inCidadaoDesaparecido=" + inCidadaoDesaparecido +
                ", inCidadaoVitimaViolencia=" + inCidadaoVitimaViolencia +
                ", inCidadaoNecessitaCuidado=" + inCidadaoNecessitaCuidado +
                ", inCidadaoSituacaoRua=" + inCidadaoSituacaoRua +
                '}';
    }
}
