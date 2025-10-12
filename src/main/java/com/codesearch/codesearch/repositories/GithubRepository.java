package com.codesearch.codesearch.repositories;


import com.codesearch.codesearch.models.Github;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;
import java.util.Optional;

public interface GithubRepository extends ElasticsearchRepository<Github, String> {
    List<Github> findByRepoName(String repoName);
    List<Github> findByFilePath(String filePath);
    List<Github> findByName(String fileName);
    List<Github> findByLanguage(String language);
    List<Github> findByContent(String content);
    Optional<Github> contentByHash(String contentHash);


}

