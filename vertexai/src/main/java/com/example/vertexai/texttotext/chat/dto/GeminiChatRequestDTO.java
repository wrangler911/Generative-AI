package com.example.vertexai.texttotext.chat.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonNaming
@JsonInclude(NON_NULL)
public class GeminiChatRequestDTO
{
    private List<Content> contents;

    private Content systemInstruction;

    private GenerationConfig generationConfig;

    public List<Content> getContents() {
        return contents;
    }

    public void setContents(List<Content> contents) {
        this.contents = contents;
    }

    public Content getSystemInstruction() {
        return systemInstruction;
    }

    public void setSystemInstruction(Content systemInstruction) {
        this.systemInstruction = systemInstruction;
    }

    public GenerationConfig getGenerationConfig() {
        return generationConfig;
    }

    public void setGenerationConfig(GenerationConfig generationConfig) {
        this.generationConfig = generationConfig;
    }

    @Override
    public String toString() {
        return "GeminiChatRequestDTO{" +
                "contents=" + contents +
                ", systemInstruction=" + systemInstruction +
                ", generationConfig=" + generationConfig +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeminiChatRequestDTO that = (GeminiChatRequestDTO) o;
        return Objects.equals(contents, that.contents) && Objects.equals(systemInstruction, that.systemInstruction) && Objects.equals(generationConfig, that.generationConfig);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contents, systemInstruction, generationConfig);
    }
}
