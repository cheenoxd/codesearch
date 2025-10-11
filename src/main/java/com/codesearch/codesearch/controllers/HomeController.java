package com.codesearch.codesearch.controllers;

import com.codesearch.codesearch.OAuthConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    private OAuthConnection oauthConnection;

    @GetMapping("/")
    public String home(OAuth2AuthenticationToken authentication) {
        if (authentication == null) {
            return "❌ Not authenticated. Please <a href=\"/oauth2/authorization/github\">log in</a>.";
        }

        // 🧩 This triggers your save/update logic
        String token = oauthConnection.handleLogin(authentication);

        return "✅ Logged in successfully with GitHub! Token saved to DB.";
    }
}
