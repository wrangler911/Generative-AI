package com.example.vertexai.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class VertexAIProperties
{
    @Value("${PROJECT_ID:}")
    private String projectId;

    @Value("${LOCATION_ID:}")
    private String locationId;

    @Value("${API_ENDPOINT:us-central1-aiplatform.googleapis.com}")
    private String apiEndpoint;

    @Value("${MODEL_ID:gemini-1.5-flash-001}")
    private String modelId;

    public String getProjectId() {
        return projectId;
    }

    public String getLocationId() {
        return locationId;
    }

    public String getApiEndpoint() {
        return apiEndpoint;
    }

    public String getModelId() {
        return modelId;
    }
}