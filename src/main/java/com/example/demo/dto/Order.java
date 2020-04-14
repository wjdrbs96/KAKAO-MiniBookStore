package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private int orderId;
    private String isbn;
    private String title;
    private int price;
    private String url;
    private int number;

    public Order(String isbn, String title, int price, String url, int number) {
        this.isbn = isbn;
        this.title = title;
        this.price = price;
        this.url = url;
        this.number = number;
    }
}
