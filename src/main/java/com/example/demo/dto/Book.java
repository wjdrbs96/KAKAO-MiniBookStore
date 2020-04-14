package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {
    int bookId;
    private String authors;
    private String contents;
    private String publisher;
    private String title;
    private int price;
    String url;
}