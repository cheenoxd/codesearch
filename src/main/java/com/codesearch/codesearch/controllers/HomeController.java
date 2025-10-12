package com.codesearch.codesearch.controllers;

import com.codesearch.codesearch.services.GithubService;
import com.codesearch.codesearch.services.OAuthConnection;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    private OAuthConnection oauthConnection;

    @Autowired
    private GithubService githubService;

    private final ObjectMapper mapper = new ObjectMapper();

    @GetMapping("/")
    public String home(OAuth2AuthenticationToken authentication) {
        if (authentication == null) {
            return """
                ❌ Not authenticated.<br>
                Please <a href="/oauth2/authorization/github">log in with GitHub</a>.
                """;
        }

        // 1️⃣ Get user access token
        String token = oauthConnection.handleLogin(authentication);

        // 2️⃣ Fetch repos
        String reposJson = githubService.getUserRepos(token);

        // 3️⃣ Extract repo names
        StringBuilder htmlList = new StringBuilder("<ul>");
        try {
            JsonNode repos = mapper.readTree(reposJson);
            for (JsonNode repo : repos) {
                String name = repo.get("name").asText();
                String htmlUrl = repo.get("html_url").asText();
                htmlList.append("<li><a href=\"")
                        .append(htmlUrl)
                        .append("\" target=\"_blank\">")
                        .append(name)
                        .append("</a></li>");
            }
            htmlList.append("</ul>");
        } catch (Exception e) {
            htmlList = new StringBuilder("<p>⚠️ Failed to parse repositories.</p>");
        }

        // 4️⃣ Return HTML
        return """
            <html>
            <head>
                <title>My GitHub Repositories</title>
                <style>
                    body { font-family: Arial, sans-serif; margin: 2rem; color: #24292f; background: #fafbfc; }
                    ul { list-style: none; padding: 0; }
                    li { margin: 8px 0; }
                    a { color: #0969da; text-decoration: none; }
                    a:hover { text-decoration: underline; }
                </style>
            </head>
            <body>
                <h2>✅ Logged in with GitHub!</h2>
                <p>Your repositories:</p>
                %s
                <br><a href="/logout">Logout</a>
            </body>
            </html>
            """.formatted(htmlList.toString());
    }
}
