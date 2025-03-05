package com.taskmate.taskmate.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        // Get the status code from the request
        Integer statusCode = (Integer) request.getAttribute("jakarta.servlet.error.status_code");

        // Default error message
        String errorMessage = "An unexpected error occurred";

        if (statusCode != null) {
            // Print the status code for debugging
            System.out.println("Error Status Code: " + statusCode);

            switch (statusCode) {
                case 404:
                    errorMessage = "404 - Page Not Found";
                    break;
                case 500:
                    errorMessage = "500 - Internal Server Error";
                    break;
                default:
                    errorMessage = "An unexpected (general) error occurred";
                    break;
            }
            // Add status code and error message to the model
            model.addAttribute("statusCode", statusCode);
            model.addAttribute("errorMessage", errorMessage);
        }
        return "error"; // Return the error.html template
    }
}
