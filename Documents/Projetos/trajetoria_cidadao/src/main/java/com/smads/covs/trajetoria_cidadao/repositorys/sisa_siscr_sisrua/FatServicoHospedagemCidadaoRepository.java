//package com.smads.covs.trajetoria_cidadao.repositorys.sisa_siscr_sisrua;
//
//import com.smads.covs.trajetoria_cidadao.models.sisa_sicr_sisrua.FatServicoHospedagemCidadao;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//import java.math.BigInteger;
//import java.util.Date;
//import java.util.List;
//
//public interface FatServicoHospedagemCidadaoRepository
//        extends JpaRepository<FatServicoHospedagemCidadao, Integer> {
//
//    @Query("SELECT " +
//            "shc.dtVinculacao, " +
//            "shc.dtDesligamento, " +
////            "d.nmDistrito, " +
////            "sp.nmSubprefeitura, " +
//            "s.nmServico, " +
////            "ts.dcTipoServico, " +
//            "mp.dcMotivoProcura, " +
//            "md.dcMotivoDesligamento, " +
//            "op.dcOrigemProcura, " +
//            "FROM " +
//            "fatServicoHospedagemCidadao shc" +
//            "LEFT OUTER JOIN dimOrigemProcura op ON shc.cdOrigemProcura = op.cdOrigemProcura " +
//            "LEFT OUTER JOIN dimMotivoProcura mp ON shc.cdMotivoProcura = mp.ciMotivoProcura " +
//            "LEFT OUTER JOIN dimMotivoDesligamento md ON shc.cdMmotivoDesligamento = md.cdMotivoDesligamento " +
//            "LEFT OUTER JOIN dimServico s ON s.cdServico = shc.cdServicoHospedagem " +
////            "LEFT OUTER JOIN dimSubprefeitura sp ON s.cdSubprefeitura = sp.cdSubprefeitura " +
////            "LEFT OUTER JOIN dimDistrito d ON s.nrDistrito = d.nrDistrito " +
////            "LEFT OUTER JOIN dimServicoTipoServico sts ON sts.cdServico = s.cdServico " +
////            "LEFT OUTER JOIN dimTipoServico ts ON ts.cdTipoServico = sts.cdTipoServico " +
//            "WHERE " +
//            "shc.ciCidadao = :ciCidadao")
//    List<FatServicoHospedagemCidadao> findAllByCiCidadao(@Param("ciCidadao") BigInteger ciCidadao);
//}
