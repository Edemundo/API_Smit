package com.smads.covs.trajetoria_cidadao.controller;

import com.smads.covs.trajetoria_cidadao.model.DimPaisOrigem;
import com.smads.covs.trajetoria_cidadao.model.DimRaca;
import com.smads.covs.trajetoria_cidadao.model.DimTipoSexo;
import com.smads.covs.trajetoria_cidadao.service.DimPaisOrigemService;
import com.smads.covs.trajetoria_cidadao.service.DimRacaService;
import com.smads.covs.trajetoria_cidadao.service.DimTipoSexoService;
import org.springframework.stereotype.Controller;

@Controller
public class PersonalDataController {

    private final DimRacaService dimRacaService;
    private final DimTipoSexoService dimTipoSexoService;
    private final DimPaisOrigemService dimPaisOrigemService;

    public PersonalDataController(DimRacaService dimRacaService, DimTipoSexoService dimTipoSexoService, DimPaisOrigemService dimPaisOrigemService) {
        this.dimRacaService = dimRacaService;
        this.dimTipoSexoService = dimTipoSexoService;
        this.dimPaisOrigemService = dimPaisOrigemService;
    }

    public DimRaca findRacaCidadao(Integer racaCidadao){
        DimRaca Response;

        Response = dimRacaService.findByCiRaca(racaCidadao);
        return Response;
    }

    public DimTipoSexo findTipoSexo(Integer tipoSexoCidadao){
        DimTipoSexo Response;

        Response = dimTipoSexoService.findByCiTipoSexo(tipoSexoCidadao);
        return Response;
    }

    public DimPaisOrigem findPaisOrigem(Integer paisOrigemCidadao){
        DimPaisOrigem Response;

        Response = dimPaisOrigemService.findCiPaisOrigem(paisOrigemCidadao);
        return Response;
    }
}
