package com.example.similaritysearch.pinecone.client;

import com.example.similaritysearch.pinecone.dto.createindex.IndexRequestDTO;
import com.example.similaritysearch.pinecone.dto.createindex.IndexResponseDTO;
import com.example.similaritysearch.pinecone.dto.query.QueryRequestDTO;
import com.example.similaritysearch.pinecone.dto.query.QueryResponseDTO;
import com.example.similaritysearch.pinecone.dto.upsertvectors.UpsertVectorRequestDTO;
import com.example.similaritysearch.pinecone.dto.upsertvectors.UpsertVectorResponseDTO;
import com.example.similaritysearch.pinecone.properties.PineconeProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

@Service
public class PineconeClient
{
    @Autowired
    private PineconeProperties pineconeProperties;

    @Autowired
    private RestTemplate restTemplate;

    public QueryResponseDTO similaritySearch(Float[] vector)
    {
        IndexResponseDTO describeIndexResponse = describeIndex(pineconeProperties.getIndexName());
        ResponseEntity<QueryResponseDTO> response = restTemplate.exchange("https://" + describeIndexResponse.getHost() + "/" +
                        pineconeProperties.getQueryEndpoint(), HttpMethod.POST, getHttpRequest(getQueryResponseDTO(vector)),
                QueryResponseDTO.class);

        return response.getBody();
    }

    public IndexResponseDTO indexes(@RequestBody IndexRequestDTO indexRequestDTO)
    {
        ResponseEntity<IndexResponseDTO> response = restTemplate.exchange(pineconeProperties.getPineconeEndpoint()  +
                        pineconeProperties.getCreateIndexEndpoint(), HttpMethod.POST, getHttpRequest(indexRequestDTO),
                IndexResponseDTO.class);
        return response.getBody();
    }

    public UpsertVectorResponseDTO upsert(@RequestBody UpsertVectorRequestDTO upsertVectorRequestDTO)
    {
        IndexResponseDTO describeIndexResponse = describeIndex(upsertVectorRequestDTO.getIndex());
        ResponseEntity<UpsertVectorResponseDTO> response = restTemplate.exchange("https://" + describeIndexResponse.getHost() + "/" +
                        pineconeProperties.getUpsertVectorEndpoint(), HttpMethod.POST, getHttpRequest(upsertVectorRequestDTO),
                UpsertVectorResponseDTO.class);
        return response.getBody();
    }

    public IndexResponseDTO describeIndex(String index)
    {
        ResponseEntity<IndexResponseDTO> response = restTemplate.exchange(pineconeProperties.getPineconeEndpoint() +
                        pineconeProperties.getCreateIndexEndpoint()  + "/" + index, HttpMethod.GET,
                getHttpRequest(null), IndexResponseDTO.class);
        return response.getBody();
    }

    private QueryRequestDTO getQueryResponseDTO(Float[] vector)
    {
        QueryRequestDTO queryRequestDTO = new QueryRequestDTO();

        queryRequestDTO.setIndex(pineconeProperties.getIndexName());
        queryRequestDTO.setNamespace(pineconeProperties.getNamespace());
        queryRequestDTO.setVector(vector);
        queryRequestDTO.setTopK(pineconeProperties.getTopK());
        queryRequestDTO.setIncludeValues(true);

        return queryRequestDTO;
    }
    private HttpEntity getHttpRequest(Object dto)
    {
        return new HttpEntity(dto, getHeaders());
    }

    private HttpHeaders getHeaders()
    {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        headers.add("Api-Key", pineconeProperties.getApiKey());
        return headers;
    }
}