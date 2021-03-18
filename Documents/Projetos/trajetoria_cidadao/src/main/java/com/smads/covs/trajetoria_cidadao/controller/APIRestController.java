package com.smads.covs.trajetoria_cidadao.controller;

import com.smads.covs.trajetoria_cidadao.model.DimCidadao;
import com.smads.covs.trajetoria_cidadao.service.DimCidadaoService;
import org.json.JSONException;
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
                                                           @PathVariable("dtNasc") String dtNasc) throws ParseException, JSONException {

        LocalDateTime now = LocalDateTime.now();
        Date dtNascimento;
        BigInteger intNrCpf;
        BigInteger intCdNis;

        if(dtNasc.equals("0")){
//            System.out.println("ENTROU NO IF e ~e vazia");
//            dtNasc = dateFormat.format(now);
                dtNascimento = null;

        } else {
            dtNascimento = dateFormat.parse(dtNasc);
        }
        System.out.println(dtNascimento);
        System.out.println("Data: " + dtNasc);
//        Date dtNascimento = dateFormat.parse(dtNasc);

        if(nrCpf.equals("0")){
            intNrCpf = null;
        } else {
            intNrCpf = new BigInteger(nrCpf);
        }

        if(cdNis.equals("0")){
            intCdNis = null;
        } else {
            intCdNis = new BigInteger(cdNis);
        }

        List<DimCidadao> dimCidadaos =  dimCidadaoService.findNrCpfAndCdNisAndNmCidadaoAndNmMaeAndDtNasc
                (intNrCpf, intCdNis, nmCidadao, nmMae, dtNascimento);

        if(dimCidadaos == null){
            return new ResponseEntity<>(dimCidadaos, HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(dimCidadaos, HttpStatus.OK);
        }
    }

}
