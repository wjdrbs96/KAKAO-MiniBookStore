package com.example.demo.mapper;

import com.example.demo.dto.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
    List<Book> findALl();
}
