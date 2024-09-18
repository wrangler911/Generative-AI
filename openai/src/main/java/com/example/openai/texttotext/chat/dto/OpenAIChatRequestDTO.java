package com.example.openai.texttotext.chat.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonNaming
@JsonInclude(NON_NULL)
public class OpenAIChatRequestDTO
{
    private String model;

    private List<Message> messages;

    private Float topP;

    private Float temperature;

    private Integer maxTokens;

    private Float presencePenalty;

    private Float frequencyPenalty;

    private Object responseFormat;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public Float getTopP() {
        return topP;
    }

    public void setTopP(Float topP) {
        this.topP = topP;
    }

    public Float getTemperature() {
        return temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }

    public Integer getMaxTokens() {
        return maxTokens;
    }

    public void setMaxTokens(Integer maxTokens) {
        this.maxTokens = maxTokens;
    }

    public Float getPresencePenalty() {
        return presencePenalty;
    }

    public void setPresencePenalty(Float presencePenalty) {
        this.presencePenalty = presencePenalty;
    }

    public Float getFrequencyPenalty() {
        return frequencyPenalty;
    }

    public void setFrequencyPenalty(Float frequencyPenalty) {
        this.frequencyPenalty = frequencyPenalty;
    }

    public Object getResponseFormat() {
        return responseFormat;
    }

    public void setResponseFormat(Object responseFormat) {
        this.responseFormat = responseFormat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OpenAIChatRequestDTO that = (OpenAIChatRequestDTO) o;
        return Objects.equals(model, that.model) && Objects.equals(messages, that.messages) && Objects.equals(topP, that.topP) && Objects.equals(temperature, that.temperature) && Objects.equals(maxTokens, that.maxTokens) && Objects.equals(presencePenalty, that.presencePenalty) && Objects.equals(frequencyPenalty, that.frequencyPenalty) && Objects.equals(responseFormat, that.responseFormat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, messages, topP, temperature, maxTokens, presencePenalty, frequencyPenalty, responseFormat);
    }

    @Override
    public String toString() {
        return "OpenAIChatRequestDTO{" +
                "model='" + model + '\'' +
                ", messages=" + messages +
                ", topP=" + topP +
                ", temperature=" + temperature +
                ", maxTokens=" + maxTokens +
                ", presencePenalty=" + presencePenalty +
                ", frequencyPenalty=" + frequencyPenalty +
                ", responseFormat=" + responseFormat +
                '}';
    }
}
