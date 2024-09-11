package com.example.pincone.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PineconeProperties
{
    @Value("${pinecone.endpoint:https://api.pinecone.io}")
    private String pineconeEndpoint;

    @Value("${PINECONE_API_KEY}")
    private String apiKey;

    private String createIndexEndpoint = "/indexes";

    private String upsertVectorEndpoint = "/vectors/upsert";

    private String queryEndpoint = "/query";

    public String getPineconeEndpoint()
    {
        return pineconeEndpoint;
    }

    public String getApiKey()
    {
        return apiKey;
    }

    public String getCreateIndexEndpoint()
    {
        return createIndexEndpoint;
    }

    public String getUpsertVectorEndpoint()
    {
        return upsertVectorEndpoint;
    }

    public String getQueryEndpoint() {
        return queryEndpoint;
    }
}