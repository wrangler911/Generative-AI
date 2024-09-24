package com.example.similaritysearch.vertexai.embedding.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Instance
{
    @JsonProperty("content")
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instance instance = (Instance) o;
        return Objects.equals(content, instance.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }

    @Override
    public String toString() {
        return "Instance{" +
                "content='" + content + '\'' +
                '}';
    }
}
