package com.example.vertexai.texttotext.chat.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonNaming
@JsonInclude(NON_NULL)
public class Part
{
    private String text;

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    @Override
    public String toString()
    {
        return "Part{" +
                "text='" + text + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Part that = (Part) o;
        return Objects.equals(text, that.text);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(text);
    }
}
