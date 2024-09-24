package com.example.similaritysearch.pinecone.dto.createindex;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonNaming
@JsonInclude(NON_NULL)
public class ServerlessDTO
{
    private String cloud;

    private String region;

    public ServerlessDTO(){}

    public String getCloud() {
        return cloud;
    }

    public void setCloud(String cloud) {
        this.cloud = cloud;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServerlessDTO that = (ServerlessDTO) o;
        return Objects.equals(cloud, that.cloud) && Objects.equals(region, that.region);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cloud, region);
    }

    @Override
    public String toString() {
        return "ServerlessDTO{" +
                "cloud='" + cloud + '\'' +
                ", region='" + region + '\'' +
                '}';
    }
}
