package com.shop.deviceshopclient.data;

import com.shop.deviceshopclient.api.HttpSender;

import com.shop.deviceshopclient.breaker.CircuitBreaker;

public class Client {
    private final String name;
    private final CircuitBreaker c;

    //private final Service s

    public Client(String name, CircuitBreaker c){
        this.name = name;
        this.c = c;
    }

    public void getAllDevices(){
       int statusCode = c.getAllDevices();
       if (statusCode != -1)
           System.out.println("Status code: " + statusCode);
    }

    public void visualizzaCarrello(){
        int statusCode = c.visualizzaCarrello(name);
        if (statusCode != -1)
            System.out.println("Status code: " + statusCode);
    }
    public void aggiungiAlCarrello(String disp){
        int statusCode = c.aggiungiAlCarrello(name, disp);
        if (statusCode != -1)
            System.out.println("Status code: " + statusCode);
    }
    public void cercaDispositivi(String cerca){
        int statusCode = c.cercaDispositivi(cerca);
        if (statusCode != -1)
            System.out.println("Status code: " + statusCode);
    }
}
