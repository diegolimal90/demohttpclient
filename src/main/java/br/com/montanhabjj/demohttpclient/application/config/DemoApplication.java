package br.com.montanhabjj.demohttpclient.application.config;

import br.com.montanhabjj.demohttpclient.application.enuns.RequestMethod;
import br.com.montanhabjj.demohttpclient.provider.RequestClientImpl;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.util.JSONPObject;

import java.io.IOException;
import java.net.URISyntaxException;

public class DemoApplication {


    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        ObjectMapper objectMapper = new ObjectMapper();
        var teste = new RequestClientImpl();

        var response = new Response("Diego", "30", "Lancer");

        objectMapper.writeValueAsString(response);

        var result = teste.testeRequest(RequestMethod.PATCH, objectMapper.writeValueAsString(response));

        var resultResponse = getData(result).getData();

        System.out.println(resultResponse);
//        System.out.println(teste.testeRequest());method
    }

    private static Data getData(String res) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(res, Data.class);
    }
}

class Response{
    String name;
    String age;
    String car;

    public Response(){}

    public Response(String name, String age, String car){
        this.name = name;
        this.age = age;
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String toString(){
        return "NAME: ".concat(name)
                .concat("\t| AGE: ").concat(age)
                .concat("\t| CAR: ").concat(car);
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Data{
    Object data;

    public Data() {
    }

    public Data(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}