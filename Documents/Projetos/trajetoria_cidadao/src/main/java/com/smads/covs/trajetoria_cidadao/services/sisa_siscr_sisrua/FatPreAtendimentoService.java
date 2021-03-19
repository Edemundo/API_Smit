package com.smads.covs.trajetoria_cidadao.services.sisa_siscr_sisrua;

import com.smads.covs.trajetoria_cidadao.models.sisa_sicr_sisrua.FatMovimentacaoHospedagem;
import com.smads.covs.trajetoria_cidadao.models.sisa_sicr_sisrua.FatPreAtendimento;
import com.smads.covs.trajetoria_cidadao.repositorys.sisa_siscr_sisrua.FatPreAtendimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class FatPreAtendimentoService {

    private final FatPreAtendimentoRepository fatPreAtendimentoRepository;

    @Autowired
    public FatPreAtendimentoService(FatPreAtendimentoRepository fatPreAtendimentoRepository) {
        this.fatPreAtendimentoRepository = fatPreAtendimentoRepository;
    }

    public List<FatPreAtendimento> findFatPA(BigInteger ciCidadao){
        return fatPreAtendimentoRepository.findAllByCiCidadao(ciCidadao);
    }
}
