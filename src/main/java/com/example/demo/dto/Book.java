package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
    private int bookId;
    private String isbn;
    private String authors;
    private String contents;
    private String publisher;
    private String title;
    private int price;
    private String url;

    public Book() {

    }

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