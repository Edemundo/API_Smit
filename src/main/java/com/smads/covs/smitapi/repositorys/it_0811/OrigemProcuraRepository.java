package com.smads.covs.smitapi.repositorys.it_0811;

import com.smads.covs.smitapi.models.it_0811.OrigemProcura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrigemProcuraRepository extends JpaRepository<OrigemProcura, Integer> {

  OrigemProcura findByCdOrigemProcura(Integer cdOrigemProcura);
}
