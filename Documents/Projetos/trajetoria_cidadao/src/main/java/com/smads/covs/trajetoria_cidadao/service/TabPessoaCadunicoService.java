package com.smads.covs.trajetoria_cidadao.service;

import com.smads.covs.trajetoria_cidadao.model.TabPessoaCadunico;
import com.smads.covs.trajetoria_cidadao.repository.TabPessoaCadunicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TabPessoaCadunicoService {

    private final TabPessoaCadunicoRepository tabPessoaCadunicoRepository;

    @Autowired
    public TabPessoaCadunicoService(TabPessoaCadunicoRepository tabPessoaCadunicoRepository) {
        this.tabPessoaCadunicoRepository = tabPessoaCadunicoRepository;
    }

    public TabPessoaCadunico findByNumNisPessoaAtual(String cdNis){
        return tabPessoaCadunicoRepository.findByNumNisPessoaAtual(cdNis);
    }
}
