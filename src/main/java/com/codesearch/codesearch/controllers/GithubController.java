package com.codesearch.codesearch.controllers;

import com.codesearch.codesearch.services.GithubService;
import com.codesearch.codesearch.services.OAuthConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/github")
public class GithubController {

    @Autowired
    private GithubService githubService;

    @Autowired
    private OAuthConnection oauthConnection;

    @GetMapping("/all")
    public String getAllRepos(OAuth2AuthenticationToken authentication) {
        if (authentication == null) {
            return "auth first";
        }

        String token = oauthConnection.handleLogin(authentication);
        return githubService.getUserRepos(token);
    }
}
