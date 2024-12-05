package com.chatbot.chatbot.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class OpenAIService {
    private final ChatClient chatClient;

    private final ChatModel chatModel;

    private final VectorStore vectorStore;

    OpenAIService(ChatClient.Builder chatClientBuilder, ChatModel chatModel, VectorStore vectorStore) {
        this.chatClient = chatClientBuilder.build();
        this.chatModel = chatModel;
        this.vectorStore = vectorStore;
    }

    public List<Object> findSimilarDocuments(String question) {
        // Realizar la búsqueda de similitudes
        List<Document> similarDocuments = vectorStore.similaritySearch(SearchRequest.query(question).withTopK(1));

        // Mapear los resultados para obtener solo las respuestas, no las preguntas
        return similarDocuments.stream()
                .map(doc -> doc.getMetadata().get("answer"))  // Accede a la respuesta en el campo "answer"
                .collect(Collectors.toList());
    }

    public String findSimilarDocumentsChat(String question) {
        List<Document> similarDocuments = vectorStore.similaritySearch(SearchRequest.query(question).withTopK(1));
        String context = similarDocuments.stream()
                .map(doc -> (String) doc.getMetadata().get("answer"))
                .collect(Collectors.joining("\n"));
        return chatClient.prompt( new Prompt("Este es el siguiente fragmento de información: '" + context + "' Y esta es la pregunta: '" + question + "' Por favor, analiza si la pregunta tiene relación con la información proporcionada. Si la pregunta está relacionada, responde utilizando esa información tal cual, sin hacer modificaciones. Si la pregunta no está relacionada, indica que la pregunta debe ser reformulada para poder ser respondida adecuadamente. Responde como si fueses un chatbot Argentino")).call().content();
    }
}
