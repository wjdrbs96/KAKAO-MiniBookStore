package com.example.demo.controller;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

@RestController
public class TestController {

    @GetMapping("test/all")
    public ResponseEntity<String> BookMain() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://dapi.kakao.com/v3/search/book?target=title&query=자존감수업";
        String svcKey = "KakaoAK 856ec0be1a62b01007353103f2cbc64d";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application","json", StandardCharsets.UTF_8));
        headers.set("Authorization", svcKey);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), String.class);

        String jsonString =
                "{"
                        +   "\"posts\": ["
                        +       "{"
                        +           "\"title\": \"how to get stroage size\","
                        +           "\"url\": \"https://codechacha.com/ko/get-free-and-total-size-of-volumes-in-android/\","
                        +           "\"draft\": false"
                        +       "},"
                        +       "{"
                        +           "\"title\": \"Android Q, Scoped Storage\","
                        +           "\"url\": \"https://codechacha.com/ko/android-q-scoped-storage/\","
                        +           "\"draft\": false"
                        +       "},"
                        +       "{"
                        +           "\"title\": \"How to parse JSON in android\","
                        +           "\"url\": \"https://codechacha.com/ko/how-to-parse-json-in-android/\","
                        +           "\"draft\": true"
                        +       "}"
                        +   "]"
                        +"}";


        JSONObject jObject = new JSONObject(jsonString);
        // 배열을 가져옵니다.
        JSONArray jArray = jObject.getJSONArray("posts");

        // 배열의 모든 아이템을 출력합니다.
        for (int i = 0; i < jArray.length(); i++) {
            JSONObject obj = jArray.getJSONObject(i);
            String title = obj.getString("title");
            System.out.println("title(" + i + "): " + title);
            System.out.println();
        }

        return response;

    }
}