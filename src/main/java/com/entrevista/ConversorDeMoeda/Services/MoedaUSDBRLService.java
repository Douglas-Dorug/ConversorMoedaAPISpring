package com.entrevista.ConversorDeMoeda.Services;

import com.entrevista.ConversorDeMoeda.Entities.MoedaUSDBRL;
import com.entrevista.ConversorDeMoeda.Utils.Util;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class MoedaUSDBRLService {

    static String webservice = "https://economia.awesomeapi.com.br/json/last/";
    static int successCode = 200;

    public static MoedaUSDBRL ConverterMoedaBRL(String tipoDeConvercao) throws Exception{

        String urlChamada = webservice + tipoDeConvercao;

        try {
            URL url = new URL(urlChamada);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

            if (conexao.getResponseCode() != successCode){
                throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());
            }

            BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
            String jsonEmString = Util.convertJsonInString(resposta);

            Gson gson = new Gson();
            MoedaUSDBRL moedaUSDBRL = gson.fromJson(jsonEmString, MoedaUSDBRL.class);

            return moedaUSDBRL;
        }catch (Exception e){
            throw new Exception("Erro: " + e);
        }

    }
}
