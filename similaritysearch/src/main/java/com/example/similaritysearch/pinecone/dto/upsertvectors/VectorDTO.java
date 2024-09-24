package com.example.similaritysearch.pinecone.dto.upsertvectors;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.Arrays;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonNaming
@JsonInclude(NON_NULL)
public class VectorDTO
{
    private String id;

    private Float[] values;

    public VectorDTO(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Float[] getValues() {
        return values;
    }

    public void setValues(Float[] values) {
        this.values = values;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VectorDTO vectorDTO = (VectorDTO) o;
        return Objects.equals(id, vectorDTO.id) && Arrays.equals(values, vectorDTO.values);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id);
        result = 31 * result + Arrays.hashCode(values);
        return result;
    }

    @Override
    public String toString() {
        return "VectorDTO{" +
                "id='" + id + '\'' +
                ", values=" + Arrays.toString(values) +
                '}';
    }
}
