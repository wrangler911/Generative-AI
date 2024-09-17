package com.example.vertexai.texttotext.chat.dto;

import java.util.Objects;

import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming
public class Candidate
{
    private Content content;

    private String finishReason;

    public Content getContent()
    {
        return content;
    }

    public void setContent(Content content)
    {
        this.content = content;
    }

    public String getFinishReason()
    {
        return finishReason;
    }

    public void setFinishReason(String finishReason)
    {
        this.finishReason = finishReason;
    }

    @Override
    public String toString()
    {
        return "Candidates{" +
                "content=" + content +
                ", finishReason='" + finishReason + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Candidate that = (Candidate) o;
        return Objects.equals(content, that.content) && Objects.equals(finishReason, that.finishReason);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(content, finishReason);
    }
}
