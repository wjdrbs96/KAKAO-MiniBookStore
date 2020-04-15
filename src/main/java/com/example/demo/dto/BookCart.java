package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BookCart {
    private int cartId;
    private String isbn;
    private String title;
    private int price;
    private String url;
    private int number;

}
