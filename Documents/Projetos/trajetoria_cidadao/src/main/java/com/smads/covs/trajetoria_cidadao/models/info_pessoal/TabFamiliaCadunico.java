package com.smads.covs.trajetoria_cidadao.models.info_pessoal;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class TabFamiliaCadunico {

    @Id
    private String codFamiliarFam;

    private String qtdPessoasDomicFam;
    private String vlrRendaMediaFam;
    private String indTrabalhoInfantilFam;
    private String nomLocalidadeFam;
    private String nomTipLogradouroFam;
    private String nomTituloLogradouroFam;
    private String nomLogradouroFam;
    private String numLogradouroFam;
    private Date dtCarga;

    public TabFamiliaCadunico(String codFamiliarFam, String qtdPessoasDomicFam,
                              String vlrRendaMediaFam, String indTrabalhoInfantilFam,
                              String nomLocalidadeFam, String nomTipLogradouroFam,
                              String nomTituloLogradouroFam, String nomLogradouroFam,
                              String numLogradouroFam, Date dtCarga) {
        this.codFamiliarFam = codFamiliarFam;
        this.qtdPessoasDomicFam = qtdPessoasDomicFam;
        this.vlrRendaMediaFam = vlrRendaMediaFam;
        this.indTrabalhoInfantilFam = indTrabalhoInfantilFam;
        this.nomLocalidadeFam = nomLocalidadeFam;
        this.nomTipLogradouroFam = nomTipLogradouroFam;
        this.nomTituloLogradouroFam = nomTituloLogradouroFam;
        this.nomLogradouroFam = nomLogradouroFam;
        this.numLogradouroFam = numLogradouroFam;
        this.dtCarga = dtCarga;
    }

    public TabFamiliaCadunico(String codFamiliarFam) {
        this.codFamiliarFam = codFamiliarFam;
    }

    public TabFamiliaCadunico() {
    }

    public TabFamiliaCadunico(String qtdPessoasDomicFam, String vlrRendaMediaFam,
                              String indTrabalhoInfantilFam, String nomLocalidadeFam,
                              String nomTipLogradouroFam, String nomTituloLogradouroFam,
                              String nomLogradouroFam, String numLogradouroFam, Date dtCarga) {
        this.qtdPessoasDomicFam = qtdPessoasDomicFam;
        this.vlrRendaMediaFam = vlrRendaMediaFam;
        this.indTrabalhoInfantilFam = indTrabalhoInfantilFam;
        this.nomLocalidadeFam = nomLocalidadeFam;
        this.nomTipLogradouroFam = nomTipLogradouroFam;
        this.nomTituloLogradouroFam = nomTituloLogradouroFam;
        this.nomLogradouroFam = nomLogradouroFam;
        this.numLogradouroFam = numLogradouroFam;
        this.dtCarga = dtCarga;
    }

    public String getCodFamiliarFam() {
        return codFamiliarFam;
    }

    public String getQtdPessoasDomicFam() {
        return qtdPessoasDomicFam;
    }

    public String getVlrRendaMediaFam() {
        return vlrRendaMediaFam;
    }

    public String getIndTrabalhoInfantilFam() {
        return indTrabalhoInfantilFam;
    }

    public String getNomLocalidadeFam() {
        return nomLocalidadeFam;
    }

    public String getNomTipLogradouroFam() {
        return nomTipLogradouroFam;
    }

    public String getNomTituloLogradouroFam() {
        return nomTituloLogradouroFam;
    }

    public String getNomLogradouroFam() {
        return nomLogradouroFam;
    }

    public String getNumLogradouroFam() {
        return numLogradouroFam;
    }

    public Date getDtCarga() {
        return dtCarga;
    }

    public void setCodFamiliarFam(String codFamiliarFam) {
        this.codFamiliarFam = codFamiliarFam;
    }

    public void setQtdPessoasDomicFam(String qtdPessoasDomicFam) {
        this.qtdPessoasDomicFam = qtdPessoasDomicFam;
    }

    public void setVlrRendaMediaFam(String vlrRendaMediaFam) {
        this.vlrRendaMediaFam = vlrRendaMediaFam;
    }

    public void setIndTrabalhoInfantilFam(String indTrabalhoInfantilFam) {
        this.indTrabalhoInfantilFam = indTrabalhoInfantilFam;
    }

    public void setNomLocalidadeFam(String nomLocalidadeFam) {
        this.nomLocalidadeFam = nomLocalidadeFam;
    }

    public void setNomTipLogradouroFam(String nomTipLogradouroFam) {
        this.nomTipLogradouroFam = nomTipLogradouroFam;
    }

    public void setNomTituloLogradouroFam(String nomTituloLogradouroFam) {
        this.nomTituloLogradouroFam = nomTituloLogradouroFam;
    }

    public void setNomLogradouroFam(String nomLogradouroFam) {
        this.nomLogradouroFam = nomLogradouroFam;
    }

    public void setNumLogradouroFam(String numLogradouroFam) {
        this.numLogradouroFam = numLogradouroFam;
    }

    public void setDtCarga(Date dtCarga) {
        this.dtCarga = dtCarga;
    }

    @Override
    public String toString() {
        return "TabFamiliaCadunico{" +
                "codFamiliarFam='" + codFamiliarFam + '\'' +
                ", qtdPessoasDomicFam='" + qtdPessoasDomicFam + '\'' +
                ", vlrRendaMediaFam='" + vlrRendaMediaFam + '\'' +
                ", indTrabalhoInfantilFam='" + indTrabalhoInfantilFam + '\'' +
                ", nomLocalidadeFam='" + nomLocalidadeFam + '\'' +
                ", nomTipLogradouroFam='" + nomTipLogradouroFam + '\'' +
                ", nomTituloLogradouroFam='" + nomTituloLogradouroFam + '\'' +
                ", nomLogradouroFam='" + nomLogradouroFam + '\'' +
                ", numLogradouroFam='" + numLogradouroFam + '\'' +
                ", dtCarga='" + dtCarga + '\'' +
                '}';
    }
}
