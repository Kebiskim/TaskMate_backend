package com.taskmate.taskmate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";  // index.html 파일을 반환 (resources/templates에 위치해야 함)
    }
}
