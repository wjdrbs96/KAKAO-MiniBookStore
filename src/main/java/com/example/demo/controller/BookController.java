package com.example.demo.controller;

import com.example.demo.dto.Book;
import com.example.demo.mapper.BookMapper;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * 설명 : XXXXXXXXXXX
 *
 * @author Groot(조민국) / dev.mingood@sk.com
 * @since 2020. 04. 12
 */
@Slf4j
@SuppressWarnings("DuplicatedCode")
@Controller
public class BookController {

    @Autowired BookMapper bookMapper;

    @PostMapping("book/all")
    public String BookAll(Model model,
                          @RequestParam("search") String search) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://dapi.kakao.com/v3/search/book?target=title&query=" + search;
        String svcKey = "KakaoAK 856ec0be1a62b01007353103f2cbc64d";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application","json", StandardCharsets.UTF_8));
        headers.set("Authorization", svcKey);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), String.class);

        // 비교 START
        JSONObject jsonObject1 = new JSONObject(response);
        JSONObject jsonObject = new JSONObject(response.getBody());

        // 배열을 가져옵니다.
        JSONArray bookList = jsonObject.getJSONArray("documents");

        List<Book> list = new ArrayList<>();
        for (int i = 0; i < bookList.length(); i++) {
            JSONObject book = bookList.getJSONObject(i);
            Book bo = new Book(book.getString("isbn"), book.getJSONArray("authors").getString(0), book.getString("contents"), book.getString("publisher"), book.getString("title"),
                    book.getInt("price"), book.getString("thumbnail"));

            list.add(bo);
        }


        model.addAttribute("BookList", list);

        return "user/index";
    }

    @GetMapping("book/default")
    public String BookDefault(Model model) {
        List<Book> list = bookMapper.findALl();
        model.addAttribute("BookList", list);

        return "user/index";
    }
}