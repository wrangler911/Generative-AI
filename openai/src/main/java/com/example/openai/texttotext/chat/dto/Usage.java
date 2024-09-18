package com.example.openai.texttotext.chat.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.Objects;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Usage
{
    private int completionTokens;

    private int promptTokens;

    private int totalTokens;

    public int getCompletionTokens() {
        return completionTokens;
    }

    public void setCompletionTokens(int completionTokens) {
        this.completionTokens = completionTokens;
    }

    public int getPromptTokens() {
        return promptTokens;
    }

    public void setPromptTokens(int promptTokens) {
        this.promptTokens = promptTokens;
    }

    public int getTotalTokens() {
        return totalTokens;
    }

    public void setTotalTokens(int totalTokens) {
        this.totalTokens = totalTokens;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usage that = (Usage) o;
        return completionTokens == that.completionTokens && promptTokens == that.promptTokens && totalTokens == that.totalTokens;
    }

    @Override
    public int hashCode() {
        return Objects.hash(completionTokens, promptTokens, totalTokens);
    }

    @Override
    public String toString() {
        return "UsageMetadata{" +
                "completionTokens=" + completionTokens +
                ", promptTokens=" + promptTokens +
                ", totalTokens=" + totalTokens +
                '}';
    }
}