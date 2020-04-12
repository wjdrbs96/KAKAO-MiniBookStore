package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

/**
 * 설명 : XXXXXXXXXXX
 *
 * @author Groot(조민국) / dev.mingood@sk.com
 * @since 2020. 04. 12
 */
@Slf4j
@SuppressWarnings("DuplicatedCode")
@RestController
public class JsonTestController {

    @GetMapping("book/all")
    public ResponseEntity<String> BookMain() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://dapi.kakao.com/v3/search/book?target=title&query=미움받을용기";
        String svcKey = "KakaoAK 856ec0be1a62b01007353103f2cbc64d";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application","json", StandardCharsets.UTF_8));
        headers.set("Authorization", svcKey);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), String.class);

        // 라이브러리 어떤거 임포트 되는지 알고 쓰셈.
        // 비교 START
        JSONObject jsonObject1 = new JSONObject(response);
        log.info("예제1 {}", jsonObject1);
        JSONObject jsonObject = new JSONObject(response.getBody());
        log.info("예제2 {}", jsonObject);
        // 비교 END

        // 배열을 가져옵니다.
        JSONArray bookList = jsonObject.getJSONArray("documents");
        log.info("### bookList {}", bookList);

        // 배열의 모든 아이템을 출력합니다.
        for (int i = 0; i < bookList.length(); i++) {
            JSONObject book = bookList.getJSONObject(i);
            String title = book.getString("title");
            System.out.println("title(" + i + "): " + title);
            System.out.println();
        }

        return response;

    }

}