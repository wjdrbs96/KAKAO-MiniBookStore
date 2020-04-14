package com.example.demo.mapper;

import com.example.demo.dto.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {

    void BookInsert(String isbn, String title, int price, String url, int number);
    List<Order> findAll();
}
