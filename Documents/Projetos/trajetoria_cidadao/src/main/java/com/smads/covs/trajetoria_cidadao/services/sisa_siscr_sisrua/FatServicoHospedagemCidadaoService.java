package com.smads.covs.trajetoria_cidadao.services.sisa_siscr_sisrua;

import com.smads.covs.trajetoria_cidadao.models.sisa_sicr_sisrua.FatServicoHospedagemCidadao;
import com.smads.covs.trajetoria_cidadao.repositorys.sisa_siscr_sisrua.FatServicoHospedagemCidadaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class FatServicoHospedagemCidadaoService {

    private final FatServicoHospedagemCidadaoRepository fatServicoHospedagemCidadaoRepository;

    @Autowired
    public FatServicoHospedagemCidadaoService(FatServicoHospedagemCidadaoRepository fatServicoHospedagemCidadaoRepository) {
        this.fatServicoHospedagemCidadaoRepository = fatServicoHospedagemCidadaoRepository;
    }

    public List<FatServicoHospedagemCidadao> findFatServicoHospedagemCidadao(BigInteger ciCidadao){
        List<FatServicoHospedagemCidadao> Return = fatServicoHospedagemCidadaoRepository.findAllByCiCidadao(ciCidadao);
        return Return;
    }
}
