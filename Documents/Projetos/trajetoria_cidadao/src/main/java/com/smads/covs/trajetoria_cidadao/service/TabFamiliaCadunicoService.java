package com.smads.covs.trajetoria_cidadao.service;

import com.smads.covs.trajetoria_cidadao.model.TabFamiliaCadunico;
import com.smads.covs.trajetoria_cidadao.repository.TabFamiliaCadunicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TabFamiliaCadunicoService {

    private final TabFamiliaCadunicoRepository tabFamiliaCadunicoRepository;

    @Autowired
    public TabFamiliaCadunicoService(TabFamiliaCadunicoRepository tabFamiliaCadunicoRepository) {
        this.tabFamiliaCadunicoRepository = tabFamiliaCadunicoRepository;
    }

    public TabFamiliaCadunico findByTabFamiliaCadunico(String codFamiliarFam){
        return tabFamiliaCadunicoRepository.findByCodFamiliarFam(codFamiliarFam);
    }
}
