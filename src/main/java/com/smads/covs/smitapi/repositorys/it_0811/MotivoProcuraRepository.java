package com.smads.covs.smitapi.repositorys.it_0811;

import com.smads.covs.smitapi.models.it_0811.MotivoProcura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotivoProcuraRepository extends JpaRepository<MotivoProcura, Integer> {

  MotivoProcura findByCdMotivoProcura(Integer cdMotivoProcura);
}
