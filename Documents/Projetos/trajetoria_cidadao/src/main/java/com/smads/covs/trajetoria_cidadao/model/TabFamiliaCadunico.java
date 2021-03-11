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

    public TabFamiliaCadunico() {
    }

    public TabFamiliaCadunico(String codFamiliarFam) {
        this.codFamiliarFam = codFamiliarFam;
    }

    public TabFamiliaCadunico(String codFamiliarFam, String qtdPessoasDomicFam, String vlrRendaMediaFam, String indTrabalhoInfantilFam) {
        this.codFamiliarFam = codFamiliarFam;
        this.qtdPessoasDomicFam = qtdPessoasDomicFam;
        this.vlrRendaMediaFam = vlrRendaMediaFam;
        this.indTrabalhoInfantilFam = indTrabalhoInfantilFam;
    }

    public String getCodFamiliarFam() {
        return codFamiliarFam;
    }

    public void setCodFamiliarFam(String codFamiliarFam) {
        this.codFamiliarFam = codFamiliarFam;
    }

    public String getQtdPessoasDomicFam() {
        return qtdPessoasDomicFam;
    }

    public void setQtdPessoasDomicFam(String qtdPessoasDomicFam) {
        this.qtdPessoasDomicFam = qtdPessoasDomicFam;
    }

    public String getVlrRendaMediaFam() {
        return vlrRendaMediaFam;
    }

    public void setVlrRendaMediaFam(String vlrRendaMediaFam) {
        this.vlrRendaMediaFam = vlrRendaMediaFam;
    }

    public String getIndTrabalhoInfantilFam() {
        return indTrabalhoInfantilFam;
    }

    public void setIndTrabalhoInfantilFam(String indTrabalhoInfantilFam) {
        this.indTrabalhoInfantilFam = indTrabalhoInfantilFam;
    }

    @Override
    public String toString() {
        return "TabFamiliaCadunico{" +
                "codFamiliarFam='" + codFamiliarFam + '\'' +
                ", qtdPessoasDomicFam='" + qtdPessoasDomicFam + '\'' +
                ", vlrRendaMediaFam='" + vlrRendaMediaFam + '\'' +
                ", indTrabalhoInfantilFam='" + indTrabalhoInfantilFam + '\'' +
                '}';
    }
}
