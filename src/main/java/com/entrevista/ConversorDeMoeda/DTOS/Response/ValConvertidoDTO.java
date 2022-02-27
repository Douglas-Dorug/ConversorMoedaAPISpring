package com.entrevista.ConversorDeMoeda.DTOS.Response;

public class ValConvertidoDTO {

    Double valResultado;

    public ValConvertidoDTO(Double valResultado) {
        this.valResultado = valResultado;
    }

    public Double getValResultado() {
        return valResultado;
    }

    public void setValResultado(Double valResultado) {
        this.valResultado = valResultado;
    }
}
