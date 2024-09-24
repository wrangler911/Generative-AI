package com.example.similaritysearch.vertexai.embedding.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Parameters
{
    @JsonProperty("autoTruncate")
    private Boolean autoTruncate;

    @JsonProperty("outputDimensionality")
    private Integer outputDimensionality;

    public Boolean getAutoTruncate() {

        return autoTruncate;
    }

    public void setAutoTruncate(Boolean autoTruncate) {
        this.autoTruncate = autoTruncate;
    }

    public Integer getOutputDimensionality() {
        return outputDimensionality;
    }

    public void setOutputDimensionality(Integer outputDimensionality) {
        this.outputDimensionality = outputDimensionality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parameters that = (Parameters) o;
        return Objects.equals(autoTruncate, that.autoTruncate) && Objects.equals(outputDimensionality, that.outputDimensionality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(autoTruncate, outputDimensionality);
    }

    @Override
    public String toString() {
        return "Parameters{" +
                "autoTruncate=" + autoTruncate +
                ", outputDimensionality=" + outputDimensionality +
                '}';
    }
}
