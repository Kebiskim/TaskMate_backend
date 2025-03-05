package com.taskmate.taskmate.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SwaggerController {
    @RequestMapping("/swagger-ui/index.html")
    public String redirectToSwaggerUI() {
        return "redirect:/swagger-ui/index.html";
    }
}
