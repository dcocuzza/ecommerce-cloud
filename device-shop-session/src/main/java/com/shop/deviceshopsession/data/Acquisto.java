package com.shop.deviceshopsession.data;

import java.io.Serializable;

public record Acquisto(String nome, String compatibilita, double prezzo) implements Serializable {
}
