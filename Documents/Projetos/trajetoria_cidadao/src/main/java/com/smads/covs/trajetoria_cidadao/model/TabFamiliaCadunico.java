package com.smads.covs.trajetoria_cidadao.model;

import javax.persistence.Entity;
import javax.persistence.Id;

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

    public TabFamiliaCadunico(String codFamiliarFam, String qtdPessoasDomicFam,
                              String vlrRendaMediaFam, String indTrabalhoInfantilFam,
                              String nomLocalidadeFam, String nomTipLogradouroFam,
                              String nomTituloLogradouroFam, String nomLogradouroFam,
                              String numLogradouroFam) {
        this.codFamiliarFam = codFamiliarFam;
        this.qtdPessoasDomicFam = qtdPessoasDomicFam;
        this.vlrRendaMediaFam = vlrRendaMediaFam;
        this.indTrabalhoInfantilFam = indTrabalhoInfantilFam;
        this.nomLocalidadeFam = nomLocalidadeFam;
        this.nomTipLogradouroFam = nomTipLogradouroFam;
        this.nomTituloLogradouroFam = nomTituloLogradouroFam;
        this.nomLogradouroFam = nomLogradouroFam;
        this.numLogradouroFam = numLogradouroFam;
    }

    public TabFamiliaCadunico(String codFamiliarFam) {
        this.codFamiliarFam = codFamiliarFam;
    }

    public TabFamiliaCadunico() {
    }

    public TabFamiliaCadunico(String qtdPessoasDomicFam, String vlrRendaMediaFam,
                              String indTrabalhoInfantilFam, String nomLocalidadeFam,
                              String nomTipLogradouroFam, String nomTituloLogradouroFam,
                              String nomLogradouroFam, String numLogradouroFam) {
        this.qtdPessoasDomicFam = qtdPessoasDomicFam;
        this.vlrRendaMediaFam = vlrRendaMediaFam;
        this.indTrabalhoInfantilFam = indTrabalhoInfantilFam;
        this.nomLocalidadeFam = nomLocalidadeFam;
        this.nomTipLogradouroFam = nomTipLogradouroFam;
        this.nomTituloLogradouroFam = nomTituloLogradouroFam;
        this.nomLogradouroFam = nomLogradouroFam;
        this.numLogradouroFam = numLogradouroFam;
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
                '}';
    }
}
