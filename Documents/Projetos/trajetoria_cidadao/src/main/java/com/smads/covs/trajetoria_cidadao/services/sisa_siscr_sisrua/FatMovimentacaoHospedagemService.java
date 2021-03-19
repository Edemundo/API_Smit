package com.smads.covs.trajetoria_cidadao.services.sisa_siscr_sisrua;

import com.smads.covs.trajetoria_cidadao.models.sisa_sicr_sisrua.FatMovimentacaoHospedagem;
import com.smads.covs.trajetoria_cidadao.repositorys.sisa_siscr_sisrua.FatMovimentacaoHospedagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class FatMovimentacaoHospedagemService {

    private final FatMovimentacaoHospedagemRepository fatMovimentacaoHospedagemRepository;

    @Autowired
    public FatMovimentacaoHospedagemService(FatMovimentacaoHospedagemRepository fatMovimentacaoHospedagemRepository) {
        this.fatMovimentacaoHospedagemRepository = fatMovimentacaoHospedagemRepository;
    }

    public List<FatMovimentacaoHospedagem> findMovHosp(BigInteger ciCidadao){
        return fatMovimentacaoHospedagemRepository.findAllByCiCidadao(ciCidadao);
    }
}
