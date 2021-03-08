package com.smads.covs.trajetoria_cidadao.repository;

import com.smads.covs.trajetoria_cidadao.model.DimCidadao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.Date;
import java.util.Optional;

public interface DimCidadaoRepository extends JpaRepository<DimCidadao, BigInteger> {
//    Optional<DimCidadao> findDimCidadaoByNrCpfAndCdNisAndNmCidadaoAndNmMaeAndDtNasc
//            (BigInteger nrCpf, BigInteger cdNis, String nmCidadao, String nmMae, Date dtNasc);

    DimCidadao findNrCpfAndCdNisAndNmCidadaoAndNmMaeAndDtNascInDimCidadaoByNrCpf(BigInteger nrCpf);

    DimCidadao findNrCpfAndCdNisAndNmCidadaoAndNmMaeAndDtNascInDimCidadaoByCdNis(BigInteger cdNis);

    DimCidadao findNrCpfAndCdNisAndNmCidadaoAndNmMaeAndDtNascInDimCidadaoByNmCidadaoAndNmMaeAndDtNasc(String nmCidadao, String nmMae, Date dtNasc);
}
