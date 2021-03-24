//package com.smads.covs.trajetoria_cidadao.models.sisa_sicr_sisrua;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.math.BigInteger;
//import java.util.Date;
//
//@Entity
//public class FatServicoHospedagemCidadao implements Serializable {
//
//    @Id
//    private Integer cdServicoHospedagemCidadao;
//    private Date dtVinculacao;
//    private Date dtDesligamento;
//
//    private BigInteger ciCidadao;
//
//    // Join Collumns
////    private Integer cdMotivoDesligamento;
////    private Integer cdMotivoProcura;
////    private Integer cdOrigemProcura;
//
//    @OneToOne
//    @JoinColumn(name="cd_motivo_desligamento")
//    private DimMotivoDesligamento dimMotivoDesligamento;
//
//    @OneToOne
//    @JoinColumn(name="cd_motivo_procura")
//    private DimMotivoProcura dimMotivoProcura;
//
//    @OneToOne
//    @JoinColumn(name="cd_origem_procura")
//    private DimOrigemProcura dimOrigemProcura;
//
//    @OneToOne
//    @JoinColumn(name="cd_servico_hospedagem")
//    private DimServico dimServico;
//
////    private DimDistrito dimDistrito;
////    private DimServicoTipoServico dimServicoTipoServico;
////    private DimSubprefeitura dimSubprefeitura;
////    private DimTipoServico dimTipoServico;
//
//
//    public FatServicoHospedagemCidadao() {
//    }
//
//    public FatServicoHospedagemCidadao(Integer cdServicoHospedagemCidadao) {
//        this.cdServicoHospedagemCidadao = cdServicoHospedagemCidadao;
//    }
//
//    public FatServicoHospedagemCidadao(Integer cdServicoHospedagemCidadao, Date dtVinculacao,
//                                       Date dtDesligamento, BigInteger ciCidadao,
//                                       DimMotivoDesligamento dimMotivoDesligamento, DimMotivoProcura dimMotivoProcura, DimOrigemProcura dimOrigemProcura, DimServico dimServico) {
//        this.cdServicoHospedagemCidadao = cdServicoHospedagemCidadao;
//        this.dtVinculacao = dtVinculacao;
//        this.dtDesligamento = dtDesligamento;
//        this.ciCidadao = ciCidadao;
//        this.dimMotivoDesligamento = dimMotivoDesligamento;
//        this.dimMotivoProcura = dimMotivoProcura;
//        this.dimOrigemProcura = dimOrigemProcura;
//        this.dimServico = dimServico;
//    }
//
//    public Integer getCdServicoHospedagemCidadao() {
//        return cdServicoHospedagemCidadao;
//    }
//
//    public void setCdServicoHospedagemCidadao(Integer cdServicoHospedagemCidadao) {
//        this.cdServicoHospedagemCidadao = cdServicoHospedagemCidadao;
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
//    public BigInteger getCiCidadao() {
//        return ciCidadao;
//    }
//
//    public void setCiCidadao(BigInteger ciCidadao) {
//        this.ciCidadao = ciCidadao;
//    }
//
//    public DimMotivoDesligamento getDimMotivoDesligamento() {
//        return dimMotivoDesligamento;
//    }
//
//    public void setDimMotivoDesligamento(DimMotivoDesligamento dimMotivoDesligamento) {
//        this.dimMotivoDesligamento = dimMotivoDesligamento;
//    }
//
//    public DimMotivoProcura getDimMotivoProcura() {
//        return dimMotivoProcura;
//    }
//
//    public void setDimMotivoProcura(DimMotivoProcura dimMotivoProcura) {
//        this.dimMotivoProcura = dimMotivoProcura;
//    }
//
//    public DimOrigemProcura getDimOrigemProcura() {
//        return dimOrigemProcura;
//    }
//
//    public void setDimOrigemProcura(DimOrigemProcura dimOrigemProcura) {
//        this.dimOrigemProcura = dimOrigemProcura;
//    }
//
//    public DimServico getDimServico() {
//        return dimServico;
//    }
//
//    public void setDimServico(DimServico dimServico) {
//        this.dimServico = dimServico;
//    }
//
//    @Override
//    public String toString() {
//        return "FatServicoHospedagemCidadao{" +
//                "cdServicoHospedagemCidadao=" + cdServicoHospedagemCidadao +
//                ", dtVinculacao=" + dtVinculacao +
//                ", dtDesligamento=" + dtDesligamento +
//                ", ciCidadao=" + ciCidadao +
//                ", dimMotivoDesligamento=" + dimMotivoDesligamento +
//                ", dimMotivoProcura=" + dimMotivoProcura +
//                ", dimOrigemProcura=" + dimOrigemProcura +
//                ", dimServico=" + dimServico +
//                '}';
//    }
//}
