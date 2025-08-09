package com.example.CanteenCollegeApp.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectController {

    // Redirects users after login based on their role
    @GetMapping("/redirect")
    public String redirectBasedOnRole(Authentication authentication) {
        if (authentication.getAuthorities().stream()
                .anyMatch(auth -> auth.getAuthority().equals("ROLE_ADMIN"))) {
            return "redirect:/admin";
        } else {
            return "redirect:/orders";
        }
    }

    // Optional: Custom login page route (Spring handles this if formLogin is configured)
    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Optional: Only if you're using a server-rendered HTML login page
    }
}
