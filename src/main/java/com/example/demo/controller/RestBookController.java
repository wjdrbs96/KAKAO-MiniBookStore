package com.example.demo.controller;

import com.example.demo.dto.DataVo;
import com.example.demo.dto.KakaoAPITest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("rest/book")
public class RestBookController {

    @Autowired
    private final KakaoAPITest kakaoAPITest;

    private static final String BASE_URL = "https://dapi.kakao.com/v3/search/book?target=%s&query=%s";

    @GetMapping("/all")
    public ResponseEntity<DataVo> bookALl(@RequestParam("searchType") String searchType,
                                          @RequestParam("searchKeyword") String searchKeyword) {

        String requestUrl = String.format(BASE_URL, searchType, searchKeyword);
        DataVo dataVo = kakaoAPITest.testApi(requestUrl);

        return new ResponseEntity<>(dataVo, HttpStatus.OK);
    }
}
