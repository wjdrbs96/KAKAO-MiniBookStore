package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {
    int bookId;
    private String isbn;
    private String authors;
    private String contents;
    private String publisher;
    private String title;
    private int price;
    String url;

    public Book(String isbn, String authors, String contents, String publisher, String title, int price, String url) {
        this.isbn = isbn;
        this.authors = authors;
        this.contents = contents;
        this.publisher = publisher;
        this.title = title;
        this.price = price;
        this.url = url;
    }
}