package com.smads.covs.trajetoria_cidadao.service;

import static org.junit.jupiter.api.Assertions.*;

import com.smads.covs.trajetoria_cidadao.model.DimCidadao;
import com.smads.covs.trajetoria_cidadao.repository.DimCidadaoRepository;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DimCidadaoServiceTest {

    private final DimCidadaoRepository dimCidadaoRepository;
    private List<DimCidadao> Response;

    public DimCidadaoServiceTest(DimCidadaoRepository dimCidadaoRepository) {
        this.dimCidadaoRepository = dimCidadaoRepository;
    }

    @Test
    void testFindNrCpfAndCdNisAndNmCidadaoAndNmMaeAndDtNasc() throws ParseException {
        String cpf = "12718282860";
        String nis = "12402262720";
        String nome = "MARIA FATIMA PEREIRA DE OLIVEIRA";
        String nomeMae = "MARIA PEREIRA DE OLIVEIRA";
        String data = "1972-01-12 00:00:00";

        BigInteger nrCpf = new BigInteger(cpf);
        BigInteger cdNis = new BigInteger(nis);
        Date dtNasc = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(data);

        Response = dimCidadaoRepository.findAllByNrCpf(nrCpf);
        if (Response == null) {
            Response = dimCidadaoRepository.findAllByCdNis(cdNis);
            if (Response == null) {
                Response = dimCidadaoRepository.findAllByNmCidadaoAndNmMaeAndDtNasc(nome, nomeMae, dtNasc);
            }
        }
        assertTrue(!Response.isEmpty());
    }
}