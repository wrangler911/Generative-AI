package com.example.similaritysearch.vertexai.embedding.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Prediction
{
    @JsonProperty("embeddings")
    private Embeddings embeddings;

    public Embeddings getEmbeddings() {
        return embeddings;
    }

    public void setEmbeddings(Embeddings embeddings) {
        this.embeddings = embeddings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prediction that = (Prediction) o;
        return Objects.equals(embeddings, that.embeddings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(embeddings);
    }

    @Override
    public String toString() {
        return "Prediction{" +
                "embeddings=" + embeddings +
                '}';
    }
}
