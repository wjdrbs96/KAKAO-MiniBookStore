package com.example.demo.dto;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.nio.charset.StandardCharsets;

@Slf4j
@Component
public class KakaoAPITest {

    @Autowired private RestTemplate restTemplate;

    String svcKey = "KakaoAK 856ec0be1a62b01007353103f2cbc64d";

    public DataVo testApi(String url) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application","json", StandardCharsets.UTF_8));
        headers.set("Authorization", svcKey);
        ResponseEntity<DataVo> response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), DataVo.class);

        return response.getBody();
    }
}
