package com.example.demo.mapper;

import com.example.demo.dto.BookCart;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface OrderMapper {

    void BookInsert(String isbn, String title, int price, String url, int number);
    List<BookCart> findAll();
    void BookDelete(int cartId);
}
