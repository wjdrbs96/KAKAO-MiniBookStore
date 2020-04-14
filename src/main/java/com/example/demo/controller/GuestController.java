package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GuestController {

    /**
     * 로그인 View
     *
     * @return
     */
    @GetMapping("login")
    public String login() {
        return "guest/login";
    }


    /*@PostMapping("login")
    public String login(@RequestParam("loginId") String loginId,
                        @RequestParam("password") String password) {

    }*/




}
