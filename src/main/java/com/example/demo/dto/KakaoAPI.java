package com.example.demo.dto;

import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import java.nio.charset.StandardCharsets;

public class KakaoAPI {
    public static JSONObject KakaoAPITest(String url) {
        RestTemplate restTemplate = new RestTemplate();
        String svcKey = "KakaoAK 856ec0be1a62b01007353103f2cbc64d";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application","json", StandardCharsets.UTF_8));
        headers.set("Authorization", svcKey);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), String.class);

        JSONObject jsonObject = new JSONObject(response.getBody());

        return jsonObject;
    }

}
