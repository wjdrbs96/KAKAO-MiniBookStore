package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private int cartId;
    private String bookName;
    private String isbn;
    private int price;
    private int bookCount;
    private int memberId;

}
