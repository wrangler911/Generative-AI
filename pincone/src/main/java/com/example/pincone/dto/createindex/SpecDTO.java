package com.example.pincone.dto.createindex;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonNaming
@JsonInclude(NON_NULL)
public class SpecDTO
{
    private ServerlessDTO serverless;


    public SpecDTO(){}

    public ServerlessDTO getServerless() {
        return serverless;
    }

    public void setServerless(ServerlessDTO serverless) {
        this.serverless = serverless;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpecDTO specDTO = (SpecDTO) o;
        return Objects.equals(serverless, specDTO.serverless);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serverless);
    }

    @Override
    public String toString() {
        return "SpecDTO{" +
                "serverless=" + serverless +
                '}';
    }
}
