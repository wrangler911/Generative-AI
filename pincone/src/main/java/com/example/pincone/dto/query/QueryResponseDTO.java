package com.example.pincone.dto.query;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonNaming
@JsonInclude(NON_NULL)
public class QueryResponseDTO
{

    private List<MatchesDTO> matches;

    private String namespace;

    private UsageDTO usage;

    public List<MatchesDTO> getMatches() {
        return matches;
    }

    public void setMatches(List<MatchesDTO> matches) {
        this.matches = matches;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public UsageDTO getUsage() {
        return usage;
    }

    public void setUsage(UsageDTO usage) {
        this.usage = usage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QueryResponseDTO that = (QueryResponseDTO) o;
        return Objects.equals(matches, that.matches) && Objects.equals(namespace, that.namespace) && Objects.equals(usage, that.usage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matches, namespace, usage);
    }

    @Override
    public String toString() {
        return "QueryResponseDTO{" +
                "matches=" + matches +
                ", namespace='" + namespace + '\'' +
                ", usage=" + usage +
                '}';
    }
}