package com.example.similaritysearch.rest;

import com.example.similaritysearch.dto.SimilaritySearchRequestDTO;
import com.example.similaritysearch.dto.SimilaritySearchResponseDTO;
import com.example.similaritysearch.service.SimilaritySearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/similaritySearch/v1/")
public class SimilaritySearchController
{
    @Autowired
    private SimilaritySearchService similaritySearchService;

    @PostMapping("search")
    public ResponseEntity<SimilaritySearchResponseDTO> search(@RequestBody SimilaritySearchRequestDTO similaritySearchRequestDTO)
    {
        return ResponseEntity.ok(similaritySearchService.search(similaritySearchRequestDTO));
    }
}
