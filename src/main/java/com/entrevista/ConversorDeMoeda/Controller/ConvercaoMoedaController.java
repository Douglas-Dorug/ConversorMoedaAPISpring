package com.entrevista.ConversorDeMoeda.Controller;

import com.entrevista.ConversorDeMoeda.DTOS.Request.ConvercaoDTO;
import com.entrevista.ConversorDeMoeda.DTOS.Response.ValConvertidoDTO;
import com.entrevista.ConversorDeMoeda.Services.ConvercaoServices;
import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/CorvecaoMoeda")
public class ConvercaoMoedaController {

    private ConvercaoServices convercaoServices;

    @Autowired
    public ConvercaoMoedaController(ConvercaoServices convercaoServices){
        this.convercaoServices = convercaoServices;
    }

    @PostMapping(value = "/Convercao_BRL-USD", produces = MediaType.APPLICATION_JSON_VALUE)
    public ValConvertidoDTO converterBRLUSD(@RequestBody ConvercaoDTO convercaoDTO) throws Exception {
        return convercaoServices.operacapConversao(convercaoDTO.getQuantidadeMoeda(), "BRL-USD");
    }

    @PostMapping(value = "/Convercao_USD-BRL", produces = MediaType.APPLICATION_JSON_VALUE)
    public ValConvertidoDTO converterUSDBRL(@RequestBody ConvercaoDTO convercaoDTO) throws Exception {
        return convercaoServices.operacapConversao(convercaoDTO.getQuantidadeMoeda(), "USD-BRL");
    }


}