package com.example.vertexai.texttotext.chat.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonInclude(NON_NULL)
public class GenerationConfig
{
    private Float temperature;

    private Integer maxOutputTokens;

    public Float getTemperature()
    {
        return temperature;
    }

    public void setTemperature(Float temperature)
    {
        this.temperature = temperature;
    }

    public Integer getMaxOutputTokens()
    {
        return maxOutputTokens;
    }

    public void setMaxOutputTokens(Integer maxOutputTokens)
    {
        this.maxOutputTokens = maxOutputTokens;
    }

    @Override
    public String toString() {
        return "GenerationConfig{" +
                "temperature=" + temperature +
                ", maxOutputTokens=" + maxOutputTokens +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenerationConfig that = (GenerationConfig) o;
        return Objects.equals(temperature, that.temperature) && Objects.equals(maxOutputTokens, that.maxOutputTokens);
    }

    @Override
    public int hashCode() {
        return Objects.hash(temperature, maxOutputTokens);
    }
}
