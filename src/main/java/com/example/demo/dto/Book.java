package com.example.demo.dto;

import java.util.List;

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

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public String getTranslators() {
        return translators;
    }

    public void setTranslators(String translators) {
        this.translators = translators;
    }
}
