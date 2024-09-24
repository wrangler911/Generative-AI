package com.example.similaritysearch.pinecone.rest;


import com.example.similaritysearch.pinecone.client.PineconeClient;
import com.example.similaritysearch.pinecone.dto.createindex.IndexRequestDTO;
import com.example.similaritysearch.pinecone.dto.createindex.IndexResponseDTO;
import com.example.similaritysearch.pinecone.dto.query.QueryRequestDTO;
import com.example.similaritysearch.pinecone.dto.query.QueryResponseDTO;
import com.example.similaritysearch.pinecone.dto.upsertvectors.UpsertVectorRequestDTO;
import com.example.similaritysearch.pinecone.dto.upsertvectors.UpsertVectorResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pinecone/")
public class PineconeController
{
    @Autowired
    private PineconeClient pineconeClient;

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
        return ResponseEntity.ok(pineconeClient.indexes(indexRequestDTO));
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
       return ResponseEntity.ok(pineconeClient.upsert(upsertVectorRequestDTO));
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
        return ResponseEntity.ok(pineconeClient.similaritySearch(queryRequestDTO.getVector()));
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
       return ResponseEntity.ok(pineconeClient.describeIndex(index));
    }

}
