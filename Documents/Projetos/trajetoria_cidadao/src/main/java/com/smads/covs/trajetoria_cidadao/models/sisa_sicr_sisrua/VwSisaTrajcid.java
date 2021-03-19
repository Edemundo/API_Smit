package com.smads.covs.trajetoria_cidadao.models.sisa_sicr_sisrua;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Immutable
@Table(name = "`vw_sisa_trajcid`")
@Subselect("select uuid() as id, vw.* from vw_sisa_trajcid vw")
public class VwSisaTrajcid implements Serializable {

    @Id
    private String id;
    private BigInteger ciCidadao;
    private String nmDistrito;
    private String nmSubprefeitura;
    private String nmServico;
    private String dcTipoServico;
    private Integer qtVagaContratual;
    private Integer qtVagaReal;
    private String dcMotivoProcura;
    private String dcMotivoDesligamento;
    private BigInteger tempoVinculacao;
    private Date dtVinculacao;
    private Date dtDesligamento;

    public VwSisaTrajcid() {
    }

    public VwSisaTrajcid(String id) {
        this.id = id;
    }

    public VwSisaTrajcid(BigInteger ciCidadao, String nmDistrito,
                         String nmSubprefeitura, String nmServico,
                         String dcTipoServico, Integer qtVagaContratual,
                         Integer qtVagaReal, String dcMotivoProcura, String dcMotivoDesligamento,
                         BigInteger tempoVinculacao, Date dtVinculacao, Date dtDesligamento) {
        this.ciCidadao = ciCidadao;
        this.nmDistrito = nmDistrito;
        this.nmSubprefeitura = nmSubprefeitura;
        this.nmServico = nmServico;
        this.dcTipoServico = dcTipoServico;
        this.qtVagaContratual = qtVagaContratual;
        this.qtVagaReal = qtVagaReal;
        this.dcMotivoProcura = dcMotivoProcura;
        this.dcMotivoDesligamento = dcMotivoDesligamento;
        this.tempoVinculacao = tempoVinculacao;
        this.dtVinculacao = dtVinculacao;
        this.dtDesligamento = dtDesligamento;
    }

    public VwSisaTrajcid(String id, BigInteger ciCidadao, String nmDistrito,
                         String nmSubprefeitura, String nmServico, String dcTipoServico,
                         Integer qtVagaContratual, Integer qtVagaReal, String dcMotivoProcura,
                         String dcMotivoDesligamento, BigInteger tempoVinculacao, Date dtVinculacao,
                         Date dtDesligamento) {
        this.id = id;
        this.ciCidadao = ciCidadao;
        this.nmDistrito = nmDistrito;
        this.nmSubprefeitura = nmSubprefeitura;
        this.nmServico = nmServico;
        this.dcTipoServico = dcTipoServico;
        this.qtVagaContratual = qtVagaContratual;
        this.qtVagaReal = qtVagaReal;
        this.dcMotivoProcura = dcMotivoProcura;
        this.dcMotivoDesligamento = dcMotivoDesligamento;
        this.tempoVinculacao = tempoVinculacao;
        this.dtVinculacao = dtVinculacao;
        this.dtDesligamento = dtDesligamento;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigInteger getCiCidadao() {
        return ciCidadao;
    }

    public void setCiCidadao(BigInteger ciCidadao) {
        this.ciCidadao = ciCidadao;
    }

    public String getNmDistrito() {
        return nmDistrito;
    }

    public void setNmDistrito(String nmDistrito) {
        this.nmDistrito = nmDistrito;
    }

    public String getNmSubprefeitura() {
        return nmSubprefeitura;
    }

    public void setNmSubprefeitura(String nmSubprefeitura) {
        this.nmSubprefeitura = nmSubprefeitura;
    }

    public String getNmServico() {
        return nmServico;
    }

    public void setNmServico(String nmServico) {
        this.nmServico = nmServico;
    }

    public String getDcTipoServico() {
        return dcTipoServico;
    }

    public void setDcTipoServico(String dcTipoServico) {
        this.dcTipoServico = dcTipoServico;
    }

    public Integer getQtVagaContratual() {
        return qtVagaContratual;
    }

    public void setQtVagaContratual(Integer qtVagaContratual) {
        this.qtVagaContratual = qtVagaContratual;
    }

    public Integer getQtVagaReal() {
        return qtVagaReal;
    }

    public void setQtVagaReal(Integer qtVagaReal) {
        this.qtVagaReal = qtVagaReal;
    }

    public String getDcMotivoProcura() {
        return dcMotivoProcura;
    }

    public void setDcMotivoProcura(String dcMotivoProcura) {
        this.dcMotivoProcura = dcMotivoProcura;
    }

    public String getDcMotivoDesligamento() {
        return dcMotivoDesligamento;
    }

    public void setDcMotivoDesligamento(String dcMotivoDesligamento) {
        this.dcMotivoDesligamento = dcMotivoDesligamento;
    }

    public BigInteger getTempoVinculacao() {
        return tempoVinculacao;
    }

    public void setTempoVinculacao(BigInteger tempoVinculacao) {
        this.tempoVinculacao = tempoVinculacao;
    }

    public Date getDtVinculacao() {
        return dtVinculacao;
    }

    public void setDtVinculacao(Date dtVinculacao) {
        this.dtVinculacao = dtVinculacao;
    }

    public Date getDtDesligamento() {
        return dtDesligamento;
    }

    public void setDtDesligamento(Date dtDesligamento) {
        this.dtDesligamento = dtDesligamento;
    }

    @Override
    public String toString() {
        return "VwSisaTrajcid{" +
                "id='" + id + '\'' +
                ", ciCidadao=" + ciCidadao +
                ", nmDistrito='" + nmDistrito + '\'' +
                ", nmSubprefeitura='" + nmSubprefeitura + '\'' +
                ", nmServico='" + nmServico + '\'' +
                ", dcTipoServico='" + dcTipoServico + '\'' +
                ", qtVagaContratual=" + qtVagaContratual +
                ", qtVagaReal=" + qtVagaReal +
                ", dcMotivoProcura='" + dcMotivoProcura + '\'' +
                ", dcMotivoDesligamento='" + dcMotivoDesligamento + '\'' +
                ", tempoVinculacao=" + tempoVinculacao +
                ", dtVinculacao=" + dtVinculacao +
                ", dtDesligamento=" + dtDesligamento +
                '}';
    }
}
