package com.example.similaritysearch.pinecone.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PineconeProperties
{
    @Value("${pinecone.endpoint:https://api.pinecone.io}")
    private String pineconeEndpoint;

    @Value("${PINECONE_API_KEY}")
    private String apiKey;

    @Value("${pinecone.index:indextest}")
    private String indexName;

    @Value("${pinecone.namespace:namespacetest}")
    private String namespace;

    @Value("${pinecone.topK:3}")
    private Integer topK;

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

    public String getIndexName() {
        return indexName;
    }

    public String getNamespace() {
        return namespace;
    }

    public Integer getTopK() {
        return topK;
    }
}