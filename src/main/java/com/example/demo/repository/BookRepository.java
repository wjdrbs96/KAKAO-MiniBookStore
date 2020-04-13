package com.example.demo.repository;

import com.example.demo.dto.Book;

import java.util.List;

public interface BookRepository {
    List<Book> findALl();

}
