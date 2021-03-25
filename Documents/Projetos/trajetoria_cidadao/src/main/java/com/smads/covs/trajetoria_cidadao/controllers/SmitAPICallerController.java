package com.smads.covs.trajetoria_cidadao.controllers;


import com.smads.covs.trajetoria_cidadao.services.smit.SmitService;
import org.springframework.stereotype.Controller;

import java.math.BigInteger;
import java.util.List;

@Controller
public class SmitAPICallerController {

    private final SmitService smitService;

    public SmitAPICallerController(SmitService smitService) {
        this.smitService = smitService;
    }

    public List<?> getServicosData(BigInteger ciCidadao){

        return null;
    }
}
