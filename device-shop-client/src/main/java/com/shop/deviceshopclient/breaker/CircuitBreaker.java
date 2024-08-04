package com.shop.deviceshopclient.breaker;

import com.shop.deviceshopclient.api.HttpSender;


import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CircuitBreaker {
    private HttpSender s;
    private BreakerState state = new Closed();

    private CompletableFuture<Integer> task;

    public CircuitBreaker(){
        s = new HttpSender();
    }



    public int getAllDevices(){
        state = state.nextState();
        if(!state.isClosed())
            return -1;
        System.out.println("CircuitBreaker executing task");

        task = CompletableFuture.supplyAsync(() -> {

                try {
                    return s.getAllDevices();
                } catch (IOException e) {
                    System.out.println("An Exception occured in HttpSender");
                    state = new Open();
                    return -1;

                } catch (InterruptedException e) {
                    System.out.println("An Exception occured in HttpSender");
                    state = new Open();
                    return -1;
                }

        });

        return getResult();
    }



    public int visualizzaCarrello(String id){
        state = state.nextState();
        if(!state.isClosed())
            return -1;
        System.out.println("CircuitBreaker executing task");

        task = CompletableFuture.supplyAsync(() -> {

            try {
                return s.visualizzaCarrello(id);
            } catch (IOException e) {
                System.out.println("An Exception occured in HttpSender");
                state = new Open();
                return -1;

            } catch (InterruptedException e) {
                System.out.println("An Exception occured in HttpSender");
                state = new Open();
                return -1;
            }

        });

        return getResult();
    }

    public int aggiungiAlCarrello(String id, String disp){
        state = state.nextState();
        if(!state.isClosed())
            return -1;
        System.out.println("CircuitBreaker executing task");

        task = CompletableFuture.supplyAsync(() -> {

            try {
                return s.aggiungiAlCarrello(id, disp);
            } catch (IOException e) {
                System.out.println("An Exception occured in HttpSender");
                state = new Open();
                return -1;

            } catch (InterruptedException e) {
                System.out.println("An Exception occured in HttpSender");
                state = new Open();
                return -1;
            }

        });

        return getResult();
    }

    public int cercaDispositivi(String cerca){
        state = state.nextState();
        if(!state.isClosed())
            return -1;
        System.out.println("CircuitBreaker executing task");

        task = CompletableFuture.supplyAsync(() -> {

            try {
                return s.cercaDispositivi(cerca);
            } catch (IOException e) {
                System.out.println("An Exception occured in HttpSender");
                state = new Open();
                return -1;

            } catch (InterruptedException e) {
                System.out.println("An Exception occured in HttpSender");
                state = new Open();
                return -1;
            }

        });

        return getResult();
    }

    private int getResult(){
        int result = -1;
        try {
            result = task.get(300, TimeUnit.MILLISECONDS);
        } catch (ExecutionException e) {

        } catch (InterruptedException e) {

        } catch (TimeoutException e) {
            System.out.println("A timeout occurred in getting the result");
            state = new Open();
        }
        return result;
    }

}
