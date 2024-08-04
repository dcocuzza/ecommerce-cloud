package com.shop.deviceshopclient.breaker;

public interface BreakerState {
    public BreakerState nextState();
    public boolean isClosed();
}
