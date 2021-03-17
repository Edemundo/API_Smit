package com.smads.covs.trajetoria_cidadao.controller;

import com.smads.covs.trajetoria_cidadao.model.DimCidadao;
import com.smads.covs.trajetoria_cidadao.service.DimCidadaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/cidadao")
public class APIRestController {

    private final DimCidadaoService dimCidadaoService;

    DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");

    public APIRestController(DimCidadaoService dimCidadaoService) {
        this.dimCidadaoService = dimCidadaoService;
    }

    @GetMapping("/find/{nrCpf}/{cdNis}/{nmCidadao}/{nmMae}/{dtNasc}")
    public ResponseEntity<List<DimCidadao>> getDimCidadaos(@PathVariable("nrCpf") String nrCpf, @PathVariable("cdNis") String cdNis,
                                                           @PathVariable("nmCidadao") String nmCidadao, @PathVariable("nmMae") String nmMae,
                                                           @PathVariable("dtNasc") String dtNasc) throws ParseException {

        LocalDateTime now = LocalDateTime.now();
        if(dtNasc == "0"){
            System.out.println("ENTROU NO IF");
            dtNasc = dateFormat.format(now);
        }
        System.out.println(now);
        System.out.println("Data: " + dtNasc);
        Date dtNascimento = dateFormat.parse(dtNasc);

        if(nrCpf == "0"){
            nrCpf = "12345678912";
        }
        BigInteger intNrCpf = new BigInteger(nrCpf);

        if(cdNis == "0"){
            cdNis = "12345678912";
        }
        BigInteger intCdNis = new BigInteger(cdNis);

        List<DimCidadao> dimCidadaos =  dimCidadaoService.findNrCpfAndCdNisAndNmCidadaoAndNmMaeAndDtNasc
                (intNrCpf, intCdNis, nmCidadao, nmMae, dtNascimento);

        if(dimCidadaos.isEmpty()){
            return new ResponseEntity<>(dimCidadaos, HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(dimCidadaos, HttpStatus.OK);
        }
    }

}
