package com.oieb.receipts;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthController {

    // Simple in-memory user credentials
    private static final Map<String, String> USERS = Map.of(
        "user1", "password123",
        "user2", "OIEB2024",
        "user3", "securePass"
    );

    @GetMapping("/")
    public String showLoginForm() {
        return "login"; // Renders the login.html page
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("username") String username,
                              @ModelAttribute("password") String password) {
        ModelAndView mav = new ModelAndView();
        if (USERS.containsKey(username) && USERS.get(username).equals(password)) {
            mav.setViewName("submitForm"); // Redirect to the submission form
        } else {
            mav.setViewName("login");
            mav.addObject("error", "Invalid username or password");
        }
        return mav;
    }
}
