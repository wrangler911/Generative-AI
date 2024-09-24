package com.example.similaritysearch.pinecone.dto.query;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.Arrays;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonNaming
@JsonInclude(NON_NULL)
public class MatchesDTO
{
    private String id;

    private Float score;

    private Float[] values;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
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
        MatchesDTO that = (MatchesDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(score, that.score) && Arrays.equals(values, that.values);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, score);
        result = 31 * result + Arrays.hashCode(values);
        return result;
    }

    @Override
    public String toString() {
        return "MatchesDTO{" +
                "id='" + id + '\'' +
                ", score=" + score +
                ", values=" + Arrays.toString(values) +
                '}';
    }
}
