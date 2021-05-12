package com.smads.covs.smitapi.repositorys.views;

import com.smads.covs.smitapi.models.views.VTrajcidPernoiteBaseReplicada;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public interface VTrajcidPernoiteBaseReplicadaRepository
  extends JpaRepository<VTrajcidPernoiteBaseReplicada, Date> {

  List<VTrajcidPernoiteBaseReplicada> findAllByCiCidadaoOrderByDtHospedagemAsc(BigInteger ciCidadao);
}
