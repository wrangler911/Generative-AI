package com.example.pincone.rest;

import com.example.pincone.dto.upsertvectors.UpsertVectorRequestDTO;
import com.example.pincone.dto.upsertvectors.UpsertVectorResponseDTO;
import com.example.pincone.dto.createindex.IndexRequestDTO;
import com.example.pincone.dto.createindex.IndexResponseDTO;
import com.example.pincone.dto.query.QueryRequestDTO;
import com.example.pincone.dto.query.QueryResponseDTO;
import com.example.pincone.properties.PineconeProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/pinecone/")
public class PineconeController
{
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private PineconeProperties pineconeProperties;

    /**
     * Request
     *
     * {
     *     "name": "demoindex",
     *     "dimension": 2,
     *     "metric": "cosine",
     *     "spec": {
     *         "serverless": {
     *             "cloud": "gcp",
     *             "region": "us-central1"
     *         }
     *     }
     * }
     *
     * Response
     *
     * {
     *     "name": "demoindex",
     *     "dimension": 2,
     *     "metric": "cosine",
     *     "status": {
     *         "ready": false,
     *         "state": "Initializing"
     *     },
     *     "host": "{your index host}",
     *     "spec": {
     *         "serverless": {
     *             "cloud": "gcp",
     *             "region": "us-central1"
     *         }
     *     }
     * }
     *
     * @param indexRequestDTO
     * @return
     */
    @PostMapping("indexes")
    public ResponseEntity<IndexResponseDTO> indexes(@RequestBody IndexRequestDTO indexRequestDTO)
    {
        ResponseEntity<IndexResponseDTO> response = restTemplate.exchange(pineconeProperties.getPineconeEndpoint()  +
                        pineconeProperties.getCreateIndexEndpoint(), HttpMethod.POST, getRequest(indexRequestDTO),
                IndexResponseDTO.class);
        return response;
    }

    /**
     *
     * Request
     *
     * {
     *     "vectors": [
     *         {
     *             "id": "vec1",
     *             "values": [
     *                 1.0,
     *                 1.5
     *             ]
     *         },
     *         {
     *             "id": "vec2",
     *             "values": [
     *                 2.0,
     *                 1.0
     *             ]
     *         },
     *         {
     *             "id": "vec3",
     *             "values": [
     *                 0.1,
     *                 3.0
     *             ]
     *         }
     *     ],
     *     "index" : "demoindex",
     *     "namespace": "demoindex-namespace1"
     * }
     *
     * Response
     *
     * {
     *     "upsertedCount": 3
     * }
     *
     * @param upsertVectorRequestDTO
     * @return
     */
    @PostMapping("vectors/upsert")
    public ResponseEntity<UpsertVectorResponseDTO> upsert(@RequestBody UpsertVectorRequestDTO upsertVectorRequestDTO)
    {
        ResponseEntity<IndexResponseDTO> describeIndexResponse = describeIndex(upsertVectorRequestDTO.getIndex());
        ResponseEntity<UpsertVectorResponseDTO> response = restTemplate.exchange("https://" + describeIndexResponse.getBody().getHost() + "/" +
                        pineconeProperties.getUpsertVectorEndpoint(), HttpMethod.POST, getRequest(upsertVectorRequestDTO),
                UpsertVectorResponseDTO.class);
        return response;
    }

    /**
     *
     * Request
     *
     * {
     *     "index" : "demoindex",
     *     "namespace": "demoindex-namespace1",
     *     "vector": [
     *         1.0,
     *         -2.5
     *     ],
     *     "topK": 1,
     *     "includeValues": true
     * }
     *
     * Response
     *
     * {
     *     "matches": [
     *         {
     *             "id": "vec2",
     *             "score": -0.08500718,
     *             "values": [
     *                 2.0,
     *                 1.0
     *             ]
     *         }
     *     ],
     *     "namespace": "demoindex-namespace1",
     *     "usage": {
     *         "readUnits": 6
     *     }
     * }
     *
     * @param queryRequestDTO
     * @return
     */
    @PostMapping("query")
    public ResponseEntity<QueryResponseDTO> similaritySearch(@RequestBody QueryRequestDTO queryRequestDTO)
    {
        ResponseEntity<IndexResponseDTO> describeIndexResponse = describeIndex(queryRequestDTO.getIndex());
        ResponseEntity<QueryResponseDTO> response = restTemplate.exchange("https://" + describeIndexResponse.getBody().getHost() + "/" +
                        pineconeProperties.getQueryEndpoint(), HttpMethod.POST, getRequest(queryRequestDTO),
                QueryResponseDTO.class);
        return response;
    }

    /**
     * Response
     *
     * {
     *     "name": "demoindex",
     *     "dimension": 2,
     *     "metric": "cosine",
     *     "status": {
     *         "ready": true,
     *         "state": "Ready"
     *     },
     *     "host": "{your index host}",
     *     "spec": {
     *         "serverless": {
     *             "cloud": "gcp",
     *             "region": "us-central1"
     *         }
     *     }
     * }
     *
     * @param index
     * @return
     */
    @GetMapping("indexes/{index}")
    public ResponseEntity<IndexResponseDTO> describeIndex(@PathVariable String index)
    {
        ResponseEntity<IndexResponseDTO> response = restTemplate.exchange(pineconeProperties.getPineconeEndpoint() +
                        pineconeProperties.getCreateIndexEndpoint()  + "/" + index, HttpMethod.GET,
                getRequest(null), IndexResponseDTO.class);
        return response;
    }

    private HttpEntity getRequest(Object dto)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        headers.add("Api-Key", pineconeProperties.getApiKey());

        HttpEntity request = new HttpEntity(dto, headers);
        return request;
    }

}
