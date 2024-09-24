package com.example.similaritysearch.vertexai.embedding.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

public class EmbeddingRequest
{
    @JsonProperty("instances")
    private List<Instance> instances;

    private Parameters Parameters;

    public List<Instance> getInstances() {
        return instances;
    }

    public void setInstances(List<Instance> instances) {
        this.instances = instances;
    }

    public  Parameters getParameters() {
        return Parameters;
    }

    public void setParameters(Parameters parameters) {
        Parameters = parameters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmbeddingRequest that = (EmbeddingRequest) o;
        return Objects.equals(instances, that.instances) && Objects.equals(Parameters, that.Parameters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(instances, Parameters);
    }

    @Override
    public String toString() {
        return "EmbeddingRequest{" +
                "instances=" + instances +
                ", Parameters=" + Parameters +
                '}';
    }
}
