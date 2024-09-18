package com.example.openai.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OpenAIProperties
{
    @Value("${OPENAI_API_KEY}")
    private String openApiKey;

    private String apiEndpoint = "api.openai.com";

    private String chatUrl = "/v1/chat/completions";

    public String getOpenApiKey() {
        return openApiKey;
    }

    public String getApiEndpoint() {
        return apiEndpoint;
    }

    public String getChatUrl() {
        return chatUrl;
    }
}