package com.example.vertexai.texttotext.chat.client;

import com.example.vertexai.properties.VertexAIProperties;
import com.example.vertexai.texttotext.chat.dto.GeminiChatRequestDTO;
import com.example.vertexai.texttotext.chat.dto.GeminiChatResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GeminiChatClient
{
    @Autowired
    private VertexAIProperties vertexAIProperties;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private  AccessTokenProvider accessTokenProvider;


    public GeminiChatResponseDTO chat(GeminiChatRequestDTO geminiChatRequestDTO)
    {
        ResponseEntity<GeminiChatResponseDTO> response = restTemplate
                .exchange(getChatUrl(), HttpMethod.POST, getHttpRequest(geminiChatRequestDTO), GeminiChatResponseDTO.class);
        HttpStatus httpStatus = response.getStatusCode();
        if(HttpStatus.OK != httpStatus)
        {
            throw new RuntimeException("Error in sending gemini chat request");
        }
        return response.getBody();
    }

    private String getChatUrl()
    {
        return "https://" + vertexAIProperties.getApiEndpoint() +"/v1/projects/" + vertexAIProperties.getProjectId() + "/locations/" + vertexAIProperties.getLocationId() + "/publishers/google/" +
                "models/" + vertexAIProperties.getModelId() + ":generateContent";
    }

    private HttpEntity<GeminiChatRequestDTO> getHttpRequest(GeminiChatRequestDTO geminiChatRequestDTO)
    {
       return new HttpEntity(geminiChatRequestDTO, getHeaders());
    }

    private HttpHeaders getHeaders()
    {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + accessTokenProvider.getToken());
        return headers;
    }
}
