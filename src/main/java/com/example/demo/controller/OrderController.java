package com.example.demo.controller;

import com.example.demo.dto.Book;
import com.example.demo.dto.Order;
import com.example.demo.mapper.BookMapper;
import com.example.demo.mapper.OrderMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Controller
public class OrderController {

    @Autowired OrderMapper orderMapper;

    @PostMapping("cart/add")
    public String cartAdd(Model model,
                          @RequestParam("isbn") String isbn,
                          @RequestParam("number") int number) {

        String[] fisbn = isbn.split(" ");
        String url = "https://dapi.kakao.com/v3/search/book?target=isbn&query=" + fisbn[0];

        RestTemplate restTemplate = new RestTemplate();
        String svcKey = "KakaoAK 856ec0be1a62b01007353103f2cbc64d";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application","json", StandardCharsets.UTF_8));
        headers.set("Authorization", svcKey);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), String.class);

        JSONObject jsonObject = new JSONObject(response.getBody());

        // 배열을 가져옵니다.
        JSONArray bookList = jsonObject.getJSONArray("documents");
        JSONObject book = bookList.getJSONObject(0);
        System.out.println(fisbn[0]);
        System.out.println(book.getString("title"));
        System.out.println(book.getInt("price"));
        System.out.println(book.getString("thumbnail"));
        System.out.println(number);
        orderMapper.BookInsert(fisbn[0], book.getString("title"), book.getInt("price"), book.getString("thumbnail"), number);

        List<Order> orderList = orderMapper.findAll();
        model.addAttribute("orderList", orderList);
        return "user/cart";
    }

}
