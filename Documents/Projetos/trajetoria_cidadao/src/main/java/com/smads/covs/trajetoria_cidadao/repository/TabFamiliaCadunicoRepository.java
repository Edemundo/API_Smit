package com.smads.covs.trajetoria_cidadao.repository;

import com.smads.covs.trajetoria_cidadao.model.TabFamiliaCadunico;
import com.smads.covs.trajetoria_cidadao.model.TabPessoaCadunico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TabFamiliaCadunicoRepository extends JpaRepository<TabFamiliaCadunico, String> {

    TabFamiliaCadunico findByCodFamiliarFam(String CodFamiliarFam);
}
