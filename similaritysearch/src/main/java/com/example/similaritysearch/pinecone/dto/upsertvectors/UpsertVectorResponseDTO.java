package com.example.similaritysearch.pinecone.dto.upsertvectors;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonNaming
@JsonInclude(NON_NULL)
public class UpsertVectorResponseDTO
{
    private Integer upsertedCount;

    public Integer getUpsertedCount() {
        return upsertedCount;
    }

    public void setUpsertedCount(Integer upsertedCount) {
        this.upsertedCount = upsertedCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpsertVectorResponseDTO that = (UpsertVectorResponseDTO) o;
        return Objects.equals(upsertedCount, that.upsertedCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(upsertedCount);
    }

    @Override
    public String toString() {
        return "UpsertVectorResponseDTO{" +
                "upsertedCount=" + upsertedCount +
                '}';
    }
}
