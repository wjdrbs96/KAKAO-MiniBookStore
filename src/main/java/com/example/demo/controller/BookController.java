package com.example.demo.controller;

import com.example.demo.dto.Book;
import com.example.demo.dto.KakaoAPI;
import com.example.demo.mapper.BookMapper;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@SuppressWarnings("DuplicatedCode")
@Controller
public class BookController {

    @Autowired BookMapper bookMapper;

    @PostMapping("book/all")
    public String BookAll(Model model,
                          @RequestParam("select") String select,
                          @RequestParam("search") String search) throws Exception {

        String url = "";
        if (select.equals("title")) {
            url = "https://dapi.kakao.com/v3/search/book?target=title&query=" + search;
        }
        else if (select.equals("authors")) {
            url = "https://dapi.kakao.com/v3/search/book?target=person&query=" + search;
        }
        else if (select.equals("isbn")) {
            url = "https://dapi.kakao.com/v3/search/book?target=isbn&query=" + search;
        }

        JSONObject jsonObject = KakaoAPI.KakaoAPITest(url);                                 // API 받아오기 메소드로 묶음
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
        List<Book> list = bookMapper.findDefault();            // 처음에 디폴트 책 찾는 메소드
        model.addAttribute("BookList", list);

        return "user/index";
    }

    @GetMapping("book/detail")
    public String getBook(Model model,
                          @RequestParam("isbn") String isbn) {
        String[] firstIsbn = isbn.split(" ");              // isbn => 공백을 가지고 2개가 오기 때문에 처음꺼를 쓰기 위함
        String url = "https://dapi.kakao.com/v3/search/book?target=isbn&query=" + firstIsbn[0];

        JSONObject jsonObject = KakaoAPI.KakaoAPITest(url);        // 카카오 key 등록 후에 정보 객체로 받기
        JSONArray bookList = jsonObject.getJSONArray("documents");

        JSONObject book = bookList.getJSONObject(0);
        Book bo = new Book(book.getString("isbn"), book.getJSONArray("authors").getString(0), book.getString("contents"), book.getString("publisher"), book.getString("title"),
                book.getInt("price"), book.getString("thumbnail"));

        model.addAttribute("Book", bo);

        return "user/bookDetail";
    }

    @GetMapping("best/book")
    public String bestBook(Model model) {
        List<Book> list = bookMapper.findBestSeller();     // 베스트 셀러 책 찾기 메소드
        model.addAttribute("BookList", list);

        return "user/bestSeller";
    }
}