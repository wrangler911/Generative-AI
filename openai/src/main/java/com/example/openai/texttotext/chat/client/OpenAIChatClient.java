package com.example.openai.texttotext.chat.client;

import com.example.openai.properties.OpenAIProperties;
import com.example.openai.texttotext.chat.dto.OpenAIChatRequestDTO;
import com.example.openai.texttotext.chat.dto.OpenAIChatResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OpenAIChatClient
{
    @Autowired
    private OpenAIProperties openAIProperties;

    @Autowired
    private RestTemplate restTemplate;

    public OpenAIChatResponseDTO chatCompletions(OpenAIChatRequestDTO openaiChatRequestDTO)
    {
        ResponseEntity<OpenAIChatResponseDTO> response = restTemplate
                .exchange(getChatUrl(), HttpMethod.POST, getHttpRequest(openaiChatRequestDTO), OpenAIChatResponseDTO.class);
        HttpStatus httpStatus = response.getStatusCode();
        if(HttpStatus.OK != httpStatus)
        {
            throw new RuntimeException("Error in sending openai chat request");
        }
        return response.getBody();
    }

    private String getChatUrl()
    {
        return "https://" + openAIProperties.getApiEndpoint()  + openAIProperties.getChatUrl();
    }

    private HttpEntity<OpenAIChatRequestDTO> getHttpRequest(OpenAIChatRequestDTO openAIChatRequestDTO)
    {
       return new HttpEntity(openAIChatRequestDTO, getHeaders());
    }

    private HttpHeaders getHeaders()
    {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + openAIProperties.getOpenApiKey());
        return headers;
    }
}
