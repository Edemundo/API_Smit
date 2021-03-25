package com.smads.covs.smitapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/cidadao")
public class SmitAPIController {

    @GetMapping("/smit/{ciCidadao}")
    public String getServicosDados(@PathVariable("ciCidadao")BigInteger ciCidadao){

        return "Deu certo - uhu";
    }
}
