package com.example.pincone.dto.createindex;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonNaming
@JsonInclude(NON_NULL)
public class StatusDTO
{
    private boolean ready;

    private String state;

    public StatusDTO(){}

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatusDTO statusDTO = (StatusDTO) o;
        return ready == statusDTO.ready && Objects.equals(state, statusDTO.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ready, state);
    }

    @Override
    public String toString() {
        return "StatusDTO{" +
                "ready=" + ready +
                ", state='" + state + '\'' +
                '}';
    }
}
