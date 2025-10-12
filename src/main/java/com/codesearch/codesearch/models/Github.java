package com.codesearch.codesearch.models;


import jakarta.persistence.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "github")
public class Github {
    @Id
    private String id;
    private String repoName;
    private String filePath;
    private String filename;
    private String language;
    private String content;
    private String contentHash;


    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getRepoName() { return repoName; }
    public void setRepoName(String repoName) { this.repoName = repoName; }
    public String getFilePath() { return filePath; }
    public void setFilePath(String filePath) { this.filePath = filePath; }
    public String getFilename() { return filename; }
    public void setFilename(String filename) { this.filename = filename; }
    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public String getContentHash() { return contentHash; }
    public void setContentHash(String contentHash) { this.contentHash = contentHash; }

}
