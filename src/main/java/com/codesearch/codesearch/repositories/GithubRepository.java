package com.codesearch.codesearch.repositories;

import com.codesearch.codesearch.models.Github;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GithubRepository extends ElasticsearchRepository<Github, String> {

    List<Github> findByRepoName(String repoName);
    List<Github> findByFilePath(String filePath);
    List<Github> findByFilename(String filename);
    List<Github> findByLanguage(String language);
    List<Github> findByContentContaining(String content);
    Optional<Github> findByContentHash(String contentHash);
}
