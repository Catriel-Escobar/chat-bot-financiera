package com.chatbot.chatbot.controller;

import com.chatbot.chatbot.service.OpenAIService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class ChatController {

    private final OpenAIService openAIService;

    public ChatController(OpenAIService openAIService) {
        this.openAIService = openAIService;
    }

    @GetMapping("/respuesta-vector")
    public ResponseEntity<List<Object>> index(@RequestParam("question") String question) {

        return ResponseEntity.ok(openAIService.findSimilarDocuments(question));
    }
    @GetMapping("/respuesta-ia")
    public ResponseEntity<String> indexDos(@RequestParam("question") String question) {

        return ResponseEntity.ok(openAIService.findSimilarDocumentsChat(question));
    }
}
