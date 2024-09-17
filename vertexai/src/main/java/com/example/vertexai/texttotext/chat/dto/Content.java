package com.example.vertexai.texttotext.chat.dto;

import java.util.List;
import java.util.Objects;

import com.example.vertexai.texttotext.chat.dto.Part;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonNaming
@JsonInclude(NON_NULL)
public class Content
{
    private String role;

    private List<Part> parts;

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    public List<Part> getParts()
    {
        return parts;
    }

    public void setParts(List<Part> parts)
    {
        this.parts = parts;
    }

    @Override
    public String toString()
    {
        return "Content{" +
                "role='" + role + '\'' +
                ", parts=" + parts +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Content that = (Content) o;
        return Objects.equals(role, that.role) && Objects.equals(parts, that.parts);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(role, parts);
    }
}
