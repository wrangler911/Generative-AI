package com.example.similaritysearch.pinecone.dto.upsertvectors;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonNaming
@JsonInclude(NON_NULL)
public class UpsertVectorRequestDTO
{
    private String index;

    private List<VectorDTO> vectors;

    private String namespace;

    public List<VectorDTO> getVectors() {
        return vectors;
    }

    public void setVectors(List<VectorDTO> vectors) {
        this.vectors = vectors;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpsertVectorRequestDTO that = (UpsertVectorRequestDTO) o;
        return Objects.equals(index, that.index) && Objects.equals(vectors, that.vectors) && Objects.equals(namespace, that.namespace);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, vectors, namespace);
    }

    @Override
    public String toString() {
        return "UpsertVectorRequestDTO{" +
                "index='" + index + '\'' +
                ", vectors=" + vectors +
                ", namespace='" + namespace + '\'' +
                '}';
    }
}
