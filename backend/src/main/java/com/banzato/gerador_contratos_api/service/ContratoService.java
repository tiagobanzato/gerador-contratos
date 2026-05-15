package com.banzato.gerador_contratos_api.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

@Service
public class ContratoService {

    @Value("${groq.api.key}")
    private String apiKey;

    public String gerarContrato(Map<String, String> dados) {
        String prompt = String.format("""
            Gere um contrato profissional e completo em português com base nos dados abaixo.
            O contrato deve ter: título, partes envolvidas, objeto, valor, prazo, obrigações,
            penalidades e assinaturas.
            
            Tipo: %s
            Contratante: %s
            Contratado: %s
            Valor: R$ %s
            Prazo: %s
            Descrição: %s
            
            Gere o contrato completo e formal agora:
            """,
            dados.get("tipo"),
            dados.get("contratante"),
            dados.get("contratado"),
            dados.get("valor"),
            dados.get("prazo"),
            dados.get("descricao")
        );

        String url = "https://api.groq.com/openai/v1/chat/completions";
        String body = String.format("""
            {
              "model": "llama-3.3-70b-versatile",
              "messages": [
                {"role": "user", "content": "%s"}
              ]
            }
            """, prompt.replace("\"", "'").replace("\n", "\\n"));

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + apiKey)
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String respBody = response.body();

            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(respBody);
            return root.path("choices").get(0).path("message").path("content").asText();

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return "Erro ao conectar com a IA.";
        }
    }
}