package com.example.similaritysearch.pinecone.dto.query;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.Arrays;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonNaming
@JsonInclude(NON_NULL)
public class QueryRequestDTO
{
    private String index;

    private String namespace;

    private Float[] vector;

    private Integer topK;

    private boolean includeValues;

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public Float[] getVector() {
        return vector;
    }

    public void setVector(Float[] vector) {
        this.vector = vector;
    }

    public Integer getTopK() {
        return topK;
    }

    public void setTopK(Integer topK) {
        this.topK = topK;
    }

    public boolean isIncludeValues() {
        return includeValues;
    }

    public void setIncludeValues(boolean includeValues) {
        this.includeValues = includeValues;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QueryRequestDTO that = (QueryRequestDTO) o;
        return includeValues == that.includeValues && Objects.equals(index, that.index) && Objects.equals(namespace, that.namespace) && Arrays.equals(vector, that.vector) && Objects.equals(topK, that.topK);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(index, namespace, topK, includeValues);
        result = 31 * result + Arrays.hashCode(vector);
        return result;
    }

    @Override
    public String toString() {
        return "QueryRequestDTO{" +
                "index='" + index + '\'' +
                ", namespace='" + namespace + '\'' +
                ", vector=" + Arrays.toString(vector) +
                ", topK=" + topK +
                ", includeValues=" + includeValues +
                '}';
    }
}
