package com.shop.deviceshopclient.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpSender {

    public HttpSender(){}

    private String uri = "http://device-shop-server:51234/device";

    public int getAllDevices() throws IOException, InterruptedException{
        HttpRequest req = HttpRequest.newBuilder().uri(URI.create(uri)).GET().version(java.net.http.HttpClient.Version.HTTP_2).build();

        HttpClient client = HttpClient.newBuilder().build();


        HttpResponse resp = client.send(req, HttpResponse.BodyHandlers.ofString());
        System.out.println("Dati: " + resp.body());

        return resp.statusCode();

    }

    public int visualizzaCarrello(String id) throws IOException, InterruptedException{
        String newUri = uri + "/" + id;
        HttpRequest req = HttpRequest.newBuilder().uri(URI.create(newUri)).GET().version(java.net.http.HttpClient.Version.HTTP_2).build();
        HttpClient client = HttpClient.newBuilder().build();

        HttpResponse resp = client.send(req, HttpResponse.BodyHandlers.ofString());
        System.out.println("Dati: " + resp.body());

        return resp.statusCode();
    }

    public int aggiungiAlCarrello(String id, String disp) throws IOException, InterruptedException{
        String newUri = uri + "/" + id;

        HttpRequest req = HttpRequest.newBuilder().uri(URI.create(newUri)).POST(HttpRequest.BodyPublishers.ofString(disp)).version(java.net.http.HttpClient.Version.HTTP_2).build();

        HttpClient client = HttpClient.newBuilder().build();

        HttpResponse resp = client.send(req, HttpResponse.BodyHandlers.ofString());
        System.out.println("Risposta: " + resp.body());

        return resp.statusCode();
    }

    public int cercaDispositivi(String cerca) throws IOException, InterruptedException{
        String newUri = uri + "/find/" + cerca;
        HttpRequest req = HttpRequest.newBuilder().uri(URI.create(newUri)).GET().version(java.net.http.HttpClient.Version.HTTP_2).build();
        HttpClient client = HttpClient.newBuilder().build();

        HttpResponse resp = client.send(req, HttpResponse.BodyHandlers.ofString());
        System.out.println("Dati: " + resp.body());

        return resp.statusCode();
    }

}
