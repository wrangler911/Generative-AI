package com.example.similaritysearch.pinecone.dto.createindex;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonNaming
@JsonInclude(NON_NULL)
public class IndexDTO
{
    private String name;

    private Integer dimension;

    private String metric;

    public IndexDTO(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDimension() {
        return dimension;
    }

    public void setDimension(Integer dimension) {
        this.dimension = dimension;
    }

    public String getMetric() {
        return metric;
    }

    public void setMetric(String metric) {
        this.metric = metric;
    }

    public IndexDTO(String name, Integer dimension, String metric) {
        this.name = name;
        this.dimension = dimension;
        this.metric = metric;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IndexDTO indexDTO = (IndexDTO) o;
        return Objects.equals(name, indexDTO.name) && Objects.equals(dimension, indexDTO.dimension) && Objects.equals(metric, indexDTO.metric);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dimension, metric);
    }

    @Override
    public String toString() {
        return "IndexDTO{" +
                "name='" + name + '\'' +
                ", dimension=" + dimension +
                ", metric='" + metric + '\'' +
                '}';
    }
}
