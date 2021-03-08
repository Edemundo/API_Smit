package com.smads.covs.trajetoria_cidadao.controller;

import com.smads.covs.trajetoria_cidadao.model.DimCidadao;
import com.smads.covs.trajetoria_cidadao.service.DimCidadaoService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.Date;

@RestController
@RequestMapping("/cidadao")
public class DimCidadaoController {

    private final DimCidadaoService dimCidadaoService;

    public DimCidadaoController(DimCidadaoService dimCidadaoService) {
        this.dimCidadaoService = dimCidadaoService;
    }

    @GetMapping("/find/{nrCpf}/{cdNis}/{nmCidadao}/{nmMae}/{dtNasc}")
    public ResponseEntity<DimCidadao> getDimCidadaos(@PathVariable("nrCpf") BigInteger nrCpf, @PathVariable("cdNis") BigInteger cdNis,
                                          @PathVariable("nmCidadao") String nmCidadao, @PathVariable("nmMae") String nmMae,
                                          @PathVariable("dtNasc") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")Date dtNasc) {

        DimCidadao dimCidadaos =  dimCidadaoService.findNrCpfAndCdNisAndNmCidadaoAndNmMaeAndDtNascInDimCidadaoByNrCpfAndCdNisAndNmCidadaoAndNmMaeAndDtNasc(nrCpf, cdNis, nmCidadao, nmMae, dtNasc);
        return new ResponseEntity<>(dimCidadaos, HttpStatus.OK);
    }

}
