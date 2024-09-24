package com.example.similaritysearch.vertexai.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class VertexAIProperties
{
    @Value("${PROJECT_ID}")
    private String projectId;

    @Value("${LOCATION_ID}")
    private String locationId;

    @Value("${API_ENDPOINT:us-central1-aiplatform.googleapis.com}")
    private String apiEndpoint;

    @Value("${embedding.model:text-embedding-004}")
    private String embeddingModel;

    @Value("${embedding.dimension:64}")
    private Integer embeddingDimension;

    public String getProjectId() {
        return projectId;
    }

    public String getLocationId() {
        return locationId;
    }

    public String getApiEndpoint() {
        return apiEndpoint;
    }

    public String getEmbeddingModel() {
        return embeddingModel;
    }

    public Integer getEmbeddingDimension() {
        return embeddingDimension;
    }
}