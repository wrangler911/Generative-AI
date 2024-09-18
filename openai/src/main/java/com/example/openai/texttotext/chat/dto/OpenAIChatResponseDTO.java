package com.example.openai.texttotext.chat.dto;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming
public class OpenAIChatResponseDTO
{
    private String id;

    private String object;

    private Integer created;

    private String model;

    private List<Choice> choices;

    private Usage usage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public Integer getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    public Usage getUsage() {
        return usage;
    }

    public void setUsage(Usage usage) {
        this.usage = usage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OpenAIChatResponseDTO that = (OpenAIChatResponseDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(object, that.object) && Objects.equals(created, that.created) && Objects.equals(model, that.model) && Objects.equals(choices, that.choices) && Objects.equals(usage, that.usage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, object, created, model, choices, usage);
    }

    @Override
    public String toString() {
        return "OpenAIChatResponseDTO{" +
                "id='" + id + '\'' +
                ", object='" + object + '\'' +
                ", created=" + created +
                ", model='" + model + '\'' +
                ", choices=" + choices +
                ", usage=" + usage +
                '}';
    }
}
