//package com.smads.covs.trajetoria_cidadao.models.sisa_sicr_sisrua;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.util.Date;
//
//@Entity
//public class DimOrigemProcura {
//
//    @Id
//    @Column(name="cd_origem_procura")
//    private Integer cdOrigemProcura;
//    private String dcOrigemProcura;
//
//    public DimOrigemProcura() {
//    }
//
//    public DimOrigemProcura(Integer cdOrigemProcura) {
//        this.cdOrigemProcura = cdOrigemProcura;
//    }
//
//    public DimOrigemProcura(Integer cdOrigemProcura, String dcOrigemProcura) {
//        this.cdOrigemProcura = cdOrigemProcura;
//        this.dcOrigemProcura = dcOrigemProcura;
//    }
//
//    public Integer getCdOrigemProcura() {
//        return cdOrigemProcura;
//    }
//
//    public void setCdOrigemProcura(Integer cdOrigemProcura) {
//        this.cdOrigemProcura = cdOrigemProcura;
//    }
//
//    public String getDcOrigemProcura() {
//        return dcOrigemProcura;
//    }
//
//    public void setDcOrigemProcura(String dcOrigemProcura) {
//        this.dcOrigemProcura = dcOrigemProcura;
//    }
//
//    @Override
//    public String toString() {
//        return "DimOrigemProcura{" +
//                "cdOrigemProcura=" + cdOrigemProcura +
//                ", dcOrigemProcura='" + dcOrigemProcura + '\'' +
//                '}';
//    }
//}
