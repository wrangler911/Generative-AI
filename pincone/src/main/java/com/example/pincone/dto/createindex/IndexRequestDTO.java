package com.example.pincone.dto.createindex;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonNaming
@JsonInclude(NON_NULL)
public class IndexRequestDTO
{
    private String name;

    private Integer dimension;

    private String metric;

    private SpecDTO spec;

    public IndexRequestDTO(){}

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

    public SpecDTO getSpec() {
        return spec;
    }

    public void setSpec(SpecDTO spec) {
        this.spec = spec;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IndexRequestDTO that = (IndexRequestDTO) o;
        return Objects.equals(name, that.name) && Objects.equals(dimension, that.dimension) && Objects.equals(metric, that.metric) && Objects.equals(spec, that.spec);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dimension, metric, spec);
    }

    @Override
    public String toString() {
        return "IndexRequestDTO{" +
                "name='" + name + '\'' +
                ", dimension=" + dimension +
                ", metric='" + metric + '\'' +
                ", spec=" + spec +
                '}';
    }
}
