package br.com.montanhabjj.demohttpclient.provider;

import br.com.montanhabjj.demohttpclient.application.enuns.RequestMethod;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequestClientImpl {

    public String  testeRequest(RequestMethod method, String request) throws URISyntaxException, IOException, InterruptedException {

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(new URI("https://postman-echo.com/patch"))
                .method(method.getValue(), HttpRequest.BodyPublishers.ofString(request))
                .header("authorization", "BEARER 123")
                .build();

        HttpClient httpClient = HttpClient.newBuilder().build();

        var response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    public String  testeRequest() throws URISyntaxException, IOException, InterruptedException {

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(new URI("https://jsonplaceholder.typicode.com/todos"))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .header("authorization", "BEARER 123")
                .build();

        HttpClient httpClient = HttpClient.newBuilder().build();

        var response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

}
