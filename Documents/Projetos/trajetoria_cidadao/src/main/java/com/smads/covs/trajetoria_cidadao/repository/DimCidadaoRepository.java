package com.smads.covs.trajetoria_cidadao.repository;

import com.smads.covs.trajetoria_cidadao.model.DimCidadao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigInteger;
import java.util.Date;

public interface DimCidadaoRepository extends JpaRepository<DimCidadao, BigInteger> {

    DimCidadao findByNrCpf(BigInteger nrCpf);

    DimCidadao findByCdNis(BigInteger cdNis);

    DimCidadao findByNmCidadaoAndNmMaeAndDtNasc(String nmCidadao, String nmMae, Date dtNasc);

}
