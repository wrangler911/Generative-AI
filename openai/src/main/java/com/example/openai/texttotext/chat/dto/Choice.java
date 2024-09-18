package com.example.openai.texttotext.chat.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.Objects;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Choice
{
    private int index;

    private Message message;

    private String finishReason;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public String getFinishReason() {
        return finishReason;
    }

    public void setFinishReason(String finishReason) {
        this.finishReason = finishReason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Choice choice = (Choice) o;
        return index == choice.index && Objects.equals(message, choice.message) && Objects.equals(finishReason, choice.finishReason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, message, finishReason);
    }

    @Override
    public String toString() {
        return "Choice{" +
                "index=" + index +
                ", message=" + message +
                ", finishReason='" + finishReason + '\'' +
                '}';
    }
}
