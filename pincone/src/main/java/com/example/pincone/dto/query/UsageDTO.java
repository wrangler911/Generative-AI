package com.example.pincone.dto.query;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonNaming
@JsonInclude(NON_NULL)
public class UsageDTO
{
    private Integer readUnits;

    public Integer getReadUnits() {
        return readUnits;
    }

    public void setReadUnits(Integer readUnits) {
        this.readUnits = readUnits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsageDTO usageDTO = (UsageDTO) o;
        return Objects.equals(readUnits, usageDTO.readUnits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(readUnits);
    }

    @Override
    public String toString() {
        return "UsageDTO{" +
                "readUnits=" + readUnits +
                '}';
    }
}
