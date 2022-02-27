package com.entrevista.ConversorDeMoeda.Entities;

public class MoedaUSDBRL {
    USDBRL USDBRL;

    public Double getUSDBRL(){
        return USDBRL.getHigh();
    }
}

class USDBRL{

    protected Double high;

    public Double getHigh() {
        return high;
    }

}
