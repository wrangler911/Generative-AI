package com.example.vertexai.texttotext.chat.dto;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming
public class GeminiChatResponseDTO
{
    private List<Candidate> candidates;

    private UsageMetadata usageMetadata;

    public List<Candidate> getCandidates()
    {
        return candidates;
    }

    public void setCandidates(List<Candidate> candidates)
    {
        this.candidates = candidates;
    }

    public UsageMetadata getUsageMetadata()
    {
        return usageMetadata;
    }

    public void setUsageMetadata(UsageMetadata usageMetadata)
    {
        this.usageMetadata = usageMetadata;
    }

    @Override
    public String toString()
    {
        return "GenerateContentResponse{" +
                "candidates=" + candidates +
                ", usageMetadata=" + usageMetadata +
                '}';
    }

    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        GeminiChatResponseDTO that = (GeminiChatResponseDTO) o;
        return Objects.equals(candidates, that.candidates) && Objects.equals(usageMetadata, that.usageMetadata);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(candidates, usageMetadata);
    }
}
