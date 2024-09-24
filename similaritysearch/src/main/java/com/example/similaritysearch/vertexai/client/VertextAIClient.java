package com.example.similaritysearch.vertexai.client;

import com.example.similaritysearch.vertexai.embedding.dto.Parameters;
import com.example.similaritysearch.vertexai.properties.VertexAIProperties;
import com.example.similaritysearch.vertexai.embedding.dto.EmbeddingRequest;
import com.example.similaritysearch.vertexai.embedding.dto.EmbeddingResponse;
import com.example.similaritysearch.vertexai.embedding.dto.Instance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class VertextAIClient
{
    @Autowired
    private AccessTokenProvider accessTokenProvider;

    @Autowired
    private VertexAIProperties vertexAIProperties;

    @Autowired
    private RestTemplate restTemplate;


    public EmbeddingResponse embedding(String content)
    {
        EmbeddingRequest embeddingRequest = createEmbeddingRequest(content);

        ResponseEntity<EmbeddingResponse> response = restTemplate.exchange(getEmbeddingUrl(), HttpMethod.POST, getHttpRequest(embeddingRequest), EmbeddingResponse.class);
        return response.getBody();
    }

    private EmbeddingRequest createEmbeddingRequest(String content)
    {
        EmbeddingRequest embeddingRequest = new EmbeddingRequest();

        List<Instance> instances = new ArrayList<>();
        Instance instance = new Instance();
        instance.setContent(content);
        instances.add(instance);
        embeddingRequest.setInstances(instances);

        Parameters parameters = new Parameters();
        parameters.setAutoTruncate(true);
        parameters.setOutputDimensionality(vertexAIProperties.getEmbeddingDimension());
        embeddingRequest.setParameters(parameters);

        return embeddingRequest;
    }
    private String getEmbeddingUrl()
    {
        return "https://" + vertexAIProperties.getApiEndpoint() +"/v1/projects/" + vertexAIProperties.getProjectId() + "/locations/" + vertexAIProperties.getLocationId() + "/publishers/google/" +
                "models/" + vertexAIProperties.getEmbeddingModel() + ":predict";
    }

    private HttpEntity<EmbeddingRequest> getHttpRequest(EmbeddingRequest embeddingRequest)
    {
        return new HttpEntity<>(embeddingRequest, getHeaders());
    }

    private HttpHeaders getHeaders()
    {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + accessTokenProvider.getToken());
        return headers;
    }
}
