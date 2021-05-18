package com.smads.covs.smitapi.repositorys.views;

import com.smads.covs.smitapi.models.views.VTrajcidVinculadoBaseReplicada;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public interface VTrajcidVinculadoBaseReplicadaRepository
  extends JpaRepository<VTrajcidVinculadoBaseReplicada, Date> {

  List<VTrajcidVinculadoBaseReplicada> findAllByCiCidadaoOrderByDtVinculacaoDesc(BigInteger ciCidadao);
}
