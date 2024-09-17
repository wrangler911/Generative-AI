package com.example.vertexai.texttotext.chat.dto;

import java.util.Objects;

import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming
public class UsageMetadata
{
    private int promptTokenCount;

    private int candidatesTokenCount;

    private int totalTokenCount;

    public int getPromptTokenCount()
    {
        return promptTokenCount;
    }

    public void setPromptTokenCount(int promptTokenCount)
    {
        this.promptTokenCount = promptTokenCount;
    }

    public int getCandidatesTokenCount()
    {
        return candidatesTokenCount;
    }

    public void setCandidatesTokenCount(int candidatesTokenCount)
    {
        this.candidatesTokenCount = candidatesTokenCount;
    }

    public int getTotalTokenCount()
    {
        return totalTokenCount;
    }

    public void setTotalTokenCount(int totalTokenCount)
    {
        this.totalTokenCount = totalTokenCount;
    }

    @Override
    public String toString()
    {
        return "UsageMetadata{" +
                "promptTokenCount=" + promptTokenCount +
                ", candidatesTokenCount=" + candidatesTokenCount +
                ", totalTokenCount=" + totalTokenCount +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UsageMetadata that = (UsageMetadata) o;
        return promptTokenCount == that.promptTokenCount && candidatesTokenCount == that.candidatesTokenCount
                && totalTokenCount == that.totalTokenCount;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(promptTokenCount, candidatesTokenCount, totalTokenCount);
    }
}
