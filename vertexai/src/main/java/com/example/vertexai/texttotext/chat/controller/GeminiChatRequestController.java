package com.example.vertexai.texttotext.chat.controller;

import com.example.vertexai.texttotext.chat.client.GeminiChatClient;
import com.example.vertexai.texttotext.chat.dto.GeminiChatRequestDTO;
import com.example.vertexai.texttotext.chat.dto.GeminiChatResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/texttotest/vertexai/")
public class GeminiChatRequestController
{
    @Autowired
    private GeminiChatClient geminiChatClient;

    /**
     * Request
     * <br>
     *
     * {
     *     "contents": [
     *         {
     *             "role": "user",
     *             "parts": [
     *                 {
     *                     "text": "1 lb bag frozen broccoli\n1 pint heavy cream\n 1 lb pack cheese ends and pieces"
     *                 }
     *             ]
     *         }
     *     ],
     *     "systemInstruction": {
     *         "parts": [
     *         {
     *             "text": "You are an assistant for home cooks.\nYou receive a list of ingredients\nand respond with a list of recipes\nthat use those ingredients. Recipes\nwhich need no extra ingredients should\nalways be listed before those that do."
     *         }
     *       ]
     *     },
     *     "generationConfig": {
     *         "maxOutputTokens": 8192,
     *         "temperature": 1,
     *         "topP": 0.95
     *     }
     * }
     * <br><br><br>
     * Response
     * <br>
     *
     * {
     *     "candidates": [
     *         {
     *             "content": {
     *                 "role": "model",
     *                 "parts": [
     *                     {
     *                         "text": "Here are some recipes you can make with those ingredients:\n\n**No additional ingredients needed:**\n\n* **Broccoli Cheddar Soup:**  Sauté the broccoli in a little butter until tender-crisp.  Add the heavy cream and cheese ends and pieces, and simmer until the cheese is melted and the soup is creamy. \n\n**Recipes that require additional ingredients:**\n\n* **Broccoli and Cheese Quiche:** You'll need pie crust, eggs, salt, pepper, and possibly some onion or garlic.\n* **Broccoli Cheddar Casserole:** You'll need bread crumbs, butter, salt, pepper, and possibly some onion or garlic.\n* **Creamy Broccoli Pasta:**  You'll need pasta, butter, salt, pepper, and possibly some garlic.\n* **Broccoli Cheese Bites:**  You'll need flour, eggs, bread crumbs, and possibly some garlic powder.\n* **Broccoli Cheddar Soup with a Crusty Bread Topping:**  You'll need some bread for the topping, plus butter and garlic. \n\nLet me know if you have any other ingredients in your fridge, or if you'd like me to suggest specific recipes. I'm happy to help! \n"
     *                     }
     *                 ]
     *             },
     *             "finishReason": "STOP"
     *         }
     *     ],
     *     "usageMetadata": {
     *         "promptTokenCount": 65,
     *         "candidatesTokenCount": 245,
     *         "totalTokenCount": 310
     *     }
     * }
     *
     * @param geminiChatRequestDTO
     * @return
     */
    @PostMapping("chat")
    public ResponseEntity<GeminiChatResponseDTO> chat(@RequestBody GeminiChatRequestDTO geminiChatRequestDTO)
    {
        GeminiChatResponseDTO geminiChatResponseDTO = geminiChatClient.chat(geminiChatRequestDTO);
        return ResponseEntity.ok(geminiChatResponseDTO);
    }
}
