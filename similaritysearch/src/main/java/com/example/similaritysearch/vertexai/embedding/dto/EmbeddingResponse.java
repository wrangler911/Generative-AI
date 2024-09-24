package com.example.similaritysearch.vertexai.embedding.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

public class EmbeddingResponse
{
    @JsonProperty("predictions")
    private List<Prediction> predictions;

    public List<Prediction> getPredictions() {
        return predictions;
    }

    public void setPredictions(List<Prediction> predictions) {
        this.predictions = predictions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmbeddingResponse that = (EmbeddingResponse) o;
        return Objects.equals(predictions, that.predictions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(predictions);
    }

    @Override
    public String toString() {
        return "EmbeddingResponse{" +
                "predictions=" + predictions +
                '}';
    }
}
