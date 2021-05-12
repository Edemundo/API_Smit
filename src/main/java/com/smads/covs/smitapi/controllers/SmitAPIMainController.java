package com.smads.covs.smitapi.controllers;

import com.smads.covs.smitapi.models.retorno.SisaPernoiteData;
import com.smads.covs.smitapi.models.retorno.SisaVinculadoData;
import org.json.JSONException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.math.BigInteger;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/cidadao")
public class SmitAPIMainController {

  private final SisaVinculadoController sisaVinculadoController;
  private final SisaPernoiteController sisaPernoiteController;

  private List<SisaVinculadoData> lstSisaVinculadoData;
  private List<SisaPernoiteData> lstSisaPernoiteData;

  public SmitAPIMainController(SisaVinculadoController sisaVinculadoController,
                               SisaPernoiteController sisaPernoiteController) {
    this.sisaVinculadoController = sisaVinculadoController;
    this.sisaPernoiteController = sisaPernoiteController;
  }

  @GetMapping("/smit/sisav")
  public List<SisaVinculadoData> getSisaVinculadoData(@RequestParam String ciCidadao)
    throws IOException, URISyntaxException, JSONException {

    BigInteger biCiCidadao = new BigInteger(ciCidadao);
    lstSisaVinculadoData = sisaVinculadoController.SisaVinc(biCiCidadao);

    System.out.println(lstSisaVinculadoData);

    return lstSisaVinculadoData;
  }

  @GetMapping("/smit/sisap")
  public List<SisaPernoiteData> getSisaPernoiteData(@RequestParam String ciCidadao)
    throws IOException, URISyntaxException {

    BigInteger biCiCidadao = new BigInteger(ciCidadao);
    lstSisaPernoiteData = sisaPernoiteController.SisaPern(biCiCidadao);

    return lstSisaPernoiteData;
  }

//  @GetMapping("/smit/siscr")
//  public String getSiscrDados(@RequestParam String ciCidadao){
//
//    return "Deu certo - uhu";
//  }
}
