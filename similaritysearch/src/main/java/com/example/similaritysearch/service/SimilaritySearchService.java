package com.example.similaritysearch.service;

import com.example.similaritysearch.pinecone.client.PineconeClient;
import com.example.similaritysearch.pinecone.dto.query.QueryResponseDTO;
import com.example.similaritysearch.dto.SimilaritySearchRequestDTO;
import com.example.similaritysearch.dto.SimilaritySearchResponseDTO;
import com.example.similaritysearch.vertexai.client.VertextAIClient;
import com.example.similaritysearch.vertexai.embedding.dto.EmbeddingResponse;
import com.example.similaritysearch.vertexai.embedding.dto.Prediction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Service
public class SimilaritySearchService
{
    @Autowired
    private VertextAIClient vertextAIClient;

    @Autowired
    private PineconeClient pineconeClient;


    public SimilaritySearchResponseDTO search(SimilaritySearchRequestDTO similaritySearchRequestDTO)
    {
        EmbeddingResponse embeddingResponse = vertextAIClient.embedding(similaritySearchRequestDTO.getQuery());

        QueryResponseDTO queryResponseDTO = pineconeClient.similaritySearch(getVector(embeddingResponse));
        List<String> result = new ArrayList<>();
        Properties vectorMapping = getVectorMapping();
        queryResponseDTO.getMatches().forEach(matchesDTO -> {
            Object value = vectorMapping.get(matchesDTO.getId());
            result.add(value != null ? (String)value : matchesDTO.getId());
        });

        SimilaritySearchResponseDTO similaritySearchResponseDTO = new SimilaritySearchResponseDTO();
        similaritySearchResponseDTO.setResult(result);

        return similaritySearchResponseDTO;
    }

    private Properties getVectorMapping()
    {
        Properties properties = new Properties();
        try
        {
            ClassPathResource resource = new ClassPathResource("vectormapping.properties");
            properties.load(resource.getInputStream());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return properties;
    }

    private Float[] getVector(EmbeddingResponse embeddingResponse)
    {
        List<Prediction> predictions = embeddingResponse.getPredictions();
        Prediction prediction = predictions.get(0);
        return prediction.getEmbeddings().getValues();
    }
}
