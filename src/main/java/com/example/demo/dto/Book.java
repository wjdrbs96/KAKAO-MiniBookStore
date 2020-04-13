package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {
    private String authors;
    private String contents;
    private String isbn;
    private String publisher;
    private String title;
    private String thumbnail;
    private int price;
    private String translators;

    public Book(String authors, String contents, String isbn, String publisher, String title, String thumbnail, int price, String translators) {
        this.authors = authors;
        this.contents = contents;
        this.isbn = isbn;
        this.publisher = publisher;
        this.title = title;
        this.thumbnail = thumbnail;
        this.price = price;
        this.translators = translators;
    }


}
