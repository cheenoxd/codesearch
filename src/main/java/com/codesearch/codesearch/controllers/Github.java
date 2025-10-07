//package com.codesearch.codesearch.controllers;
//import org.springframework.web.bind.annotation.*;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//// we want this file to download all the repos of a user and then store it into Elasticsearch
//@RestController
//@RequestMapping("/api/v1/github")
//public class Github {
//
//    private final GitHubService gitHubService;
//
////    public GitHubController(GitHubService gitHubService) {
////        this.gitHubService = gitHubService;
////    }
//
//    @GetMapping("/{username}")
//    public String getGitHubUser(@PathVariable String username) {
//        return gitHubService.getUser(username);
//    }
//
//
//
//
//
//
//}
