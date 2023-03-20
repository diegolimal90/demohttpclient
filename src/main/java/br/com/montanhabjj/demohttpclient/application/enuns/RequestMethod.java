package br.com.montanhabjj.demohttpclient.application.enuns;

public enum RequestMethod {
    POST("POST"), PUT("PUT"), PATCH("PATCH"), DELETE("DELETE"), GET("GET");

    private final String value;

    RequestMethod(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
