package com.entrevista.ConversorDeMoeda.Utils;

import java.io.BufferedReader;
import java.io.IOException;

public class Util {

    public static String convertJsonInString(BufferedReader bufferedReader) throws IOException {
        String response, jsonInString = "";
        while ((response = bufferedReader.readLine()) != null){
            jsonInString += response;
        }
        return jsonInString;
    }
}
