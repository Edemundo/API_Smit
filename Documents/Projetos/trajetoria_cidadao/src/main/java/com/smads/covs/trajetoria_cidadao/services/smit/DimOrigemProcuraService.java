//package com.smads.covs.trajetoria_cidadao.services.sisa_siscr_sisrua;
//
//import com.smads.covs.trajetoria_cidadao.models.sisa_sicr_sisrua.DimOrigemProcura;
//import com.smads.covs.trajetoria_cidadao.repositorys.sisa_siscr_sisrua.DimOrigemProcuraRepository;
//import com.smads.covs.trajetoria_cidadao.services.info_pessoal.DimPaisOrigemService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class DimOrigemProcuraService {
//
//    private final DimOrigemProcuraRepository dimOrigemProcuraRepository;
//
//    @Autowired
//    public DimOrigemProcuraService(DimOrigemProcuraRepository dimOrigemProcuraRepository){
//        this.dimOrigemProcuraRepository = dimOrigemProcuraRepository;
//    }
//
//    public List<DimOrigemProcura> findByCdOrigemProcura(Integer cdOrigemProcura){
//        List<DimOrigemProcura> listOrigemProcura = dimOrigemProcuraRepository.findByCdOrigemProcura(cdOrigemProcura);
//
//        return listOrigemProcura;
//    }
//}
