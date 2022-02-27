package com.entrevista.ConversorDeMoeda.Services;

import com.entrevista.ConversorDeMoeda.DTOS.Request.ConvercaoDTO;
import com.entrevista.ConversorDeMoeda.DTOS.Response.ValConvertidoDTO;
import com.entrevista.ConversorDeMoeda.Entities.MoedaBRLUSD;
import com.entrevista.ConversorDeMoeda.Entities.MoedaUSDBRL;
import org.springframework.stereotype.Service;

@Service
public class ConvercaoServices {

    public ValConvertidoDTO operacapConversao(Double valEntrada, String tipoConvercao) throws Exception {
        if (tipoConvercao == "BRL-USD"){
            MoedaBRLUSD moedaBRLUSD = MoedaBRLUSDService.ConverterMoedaBRL(tipoConvercao);
            Double valorConvercao = Converter(valEntrada, moedaBRLUSD.getBRLUSD());

            ValConvertidoDTO valConvertidoDTO = new ValConvertidoDTO(valorConvercao);
            return valConvertidoDTO;

        }else if (tipoConvercao == "USD-BRL"){
            MoedaUSDBRL moedaUSDBRL = MoedaUSDBRLService.ConverterMoedaBRL(tipoConvercao);
            Double valorConvercao = Converter(valEntrada,moedaUSDBRL.getUSDBRL());

            ValConvertidoDTO valConvertidoDTO = new ValConvertidoDTO(valorConvercao);
            return valConvertidoDTO;
        }
        return null;
    }

    public static Double Converter(Double money, Double highJson) throws Exception {
        Double convertedValue = money * highJson;
        return convertedValue;
    }
}
