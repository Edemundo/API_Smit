//package com.smads.covs.trajetoria_cidadao.models.json_formatter;
//
//import com.fasterxml.jackson.annotation.JsonProperty;
//
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import java.io.Serializable;
//import java.math.BigInteger;
//import java.util.Date;
//
//@Entity
//public class DataReturn implements Serializable {
//
//    @Id
//    private BigInteger ciCidadao;
//
////    // Dado pessoais do cidadão
////    private String nmCidadao;
////    private String nmMae;
////    private Date dtNasc;
////    private BigInteger cdNis;
////    private BigInteger nrCpf;
////    private String nmPais;
////    private String dcRaca;
////    private String dcSitCidadao;
////    private String dcTipoSexo;
////    private String descEndereco;
////    private Integer ageCidadao;
////
////    // Tabela Familia Cadunico
////    private float RendaMediaFam;
////
////    // Tabela Pessoa Cadunico
////    private String descAnoSerieFrequentouMemb;
////    private String descResponsavel;
////    private String descCursoFrequentouPessoaMemb;
////    private String descAnoSerieFrequentaMemb;
////    private String descCursoFrequentaMemb;
////    private String descFrequentaEscolaMemb;
////    private String descTrabMembro;
//
//    // Dados SISA
////    @JsonProperty
////    private Integer qtVagaContratual;
////    @JsonProperty
////    private Integer qtVagaReal;
//    @JsonProperty
//    private String dcMotivoProcura;
//    @JsonProperty
//    private String dcMotivoDesligamento;
//    @JsonProperty
//    private BigInteger tempoVinculacao;
//    @JsonProperty
//    private Date dtVinculacao;
//    @JsonProperty
//    private Date dtDesligamento;
//
//    // SISA - Pernoite
////    private Date dtHospedagem;
//    // private String dcIntervaloNoites
//    // private Integer numNoites
//
//    // Dados SISCR
////    @JsonProperty
////    private String nmCentroAssistencial;
////    @JsonProperty
////    private String dcTipoProvidencia[];
////    @JsonProperty
////    private String dcTipoProcura;
////    @JsonProperty
////    private Date dtPreAtendimento;
////    @JsonProperty
////    private Date dtAtualizacao;
//
//    // Dados SISA e SISA-pernoite
//    @JsonProperty
//    private String nmServico;
//    @JsonProperty
//    private String dcTipoServico;
//
//    //Dados SISA e SISCR e SISA-pernoite
//    @JsonProperty
//    private String nmDistrito;
//    @JsonProperty
//    private String nmSubprefeitura;
//
//    public DataReturn() {
//    }
//
//    public DataReturn(BigInteger ciCidadao) {
//        this.ciCidadao = ciCidadao;
//    }
//
//    public DataReturn(String dcMotivoProcura, String dcMotivoDesligamento,
//                      BigInteger tempoVinculacao, Date dtVinculacao,
//                      Date dtDesligamento, String nmServico, String dcTipoServico,
//                      String nmDistrito, String nmSubprefeitura) {
//        this.dcMotivoProcura = dcMotivoProcura;
//        this.dcMotivoDesligamento = dcMotivoDesligamento;
//        this.tempoVinculacao = tempoVinculacao;
//        this.dtVinculacao = dtVinculacao;
//        this.dtDesligamento = dtDesligamento;
//        this.nmServico = nmServico;
//        this.dcTipoServico = dcTipoServico;
//        this.nmDistrito = nmDistrito;
//        this.nmSubprefeitura = nmSubprefeitura;
//    }
//
//    public DataReturn(BigInteger ciCidadao, String dcMotivoProcura,
//                      String dcMotivoDesligamento, BigInteger tempoVinculacao,
//                      Date dtVinculacao, Date dtDesligamento, String nmServico,
//                      String dcTipoServico, String nmDistrito, String nmSubprefeitura) {
//        this.ciCidadao = ciCidadao;
//        this.dcMotivoProcura = dcMotivoProcura;
//        this.dcMotivoDesligamento = dcMotivoDesligamento;
//        this.tempoVinculacao = tempoVinculacao;
//        this.dtVinculacao = dtVinculacao;
//        this.dtDesligamento = dtDesligamento;
//        this.nmServico = nmServico;
//        this.dcTipoServico = dcTipoServico;
//        this.nmDistrito = nmDistrito;
//        this.nmSubprefeitura = nmSubprefeitura;
//    }
//
//    public BigInteger getCiCidadao() {
//        return ciCidadao;
//    }
//
//    public void setCiCidadao(BigInteger ciCidadao) {
//        this.ciCidadao = ciCidadao;
//    }
//
//    public String getDcMotivoProcura() {
//        return dcMotivoProcura;
//    }
//
//    public void setDcMotivoProcura(String dcMotivoProcura) {
//        this.dcMotivoProcura = dcMotivoProcura;
//    }
//
//    public String getDcMotivoDesligamento() {
//        return dcMotivoDesligamento;
//    }
//
//    public void setDcMotivoDesligamento(String dcMotivoDesligamento) {
//        this.dcMotivoDesligamento = dcMotivoDesligamento;
//    }
//
//    public BigInteger getTempoVinculacao() {
//        return tempoVinculacao;
//    }
//
//    public void setTempoVinculacao(BigInteger tempoVinculacao) {
//        this.tempoVinculacao = tempoVinculacao;
//    }
//
//    public Date getDtVinculacao() {
//        return dtVinculacao;
//    }
//
//    public void setDtVinculacao(Date dtVinculacao) {
//        this.dtVinculacao = dtVinculacao;
//    }
//
//    public Date getDtDesligamento() {
//        return dtDesligamento;
//    }
//
//    public void setDtDesligamento(Date dtDesligamento) {
//        this.dtDesligamento = dtDesligamento;
//    }
//
//    public String getNmServico() {
//        return nmServico;
//    }
//
//    public void setNmServico(String nmServico) {
//        this.nmServico = nmServico;
//    }
//
//    public String getDcTipoServico() {
//        return dcTipoServico;
//    }
//
//    public void setDcTipoServico(String dcTipoServico) {
//        this.dcTipoServico = dcTipoServico;
//    }
//
//    public String getNmDistrito() {
//        return nmDistrito;
//    }
//
//    public void setNmDistrito(String nmDistrito) {
//        this.nmDistrito = nmDistrito;
//    }
//
//    public String getNmSubprefeitura() {
//        return nmSubprefeitura;
//    }
//
//    public void setNmSubprefeitura(String nmSubprefeitura) {
//        this.nmSubprefeitura = nmSubprefeitura;
//    }
//
//    @Override
//    public String toString() {
//        return "DataReturn{" +
//                "ciCidadao=" + ciCidadao +
//                ", dcMotivoProcura='" + dcMotivoProcura + '\'' +
//                ", dcMotivoDesligamento='" + dcMotivoDesligamento + '\'' +
//                ", tempoVinculacao=" + tempoVinculacao +
//                ", dtVinculacao=" + dtVinculacao +
//                ", dtDesligamento=" + dtDesligamento +
//                ", nmServico='" + nmServico + '\'' +
//                ", dcTipoServico='" + dcTipoServico + '\'' +
//                ", nmDistrito='" + nmDistrito + '\'' +
//                ", nmSubprefeitura='" + nmSubprefeitura + '\'' +
//                '}';
//    }
//}
