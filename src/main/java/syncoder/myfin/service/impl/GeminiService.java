package syncoder.myfin.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import syncoder.myfin.service.LoanService;
import syncoder.myfin.service.gemini.Content;
import syncoder.myfin.service.gemini.GeminiRequest;
import syncoder.myfin.service.gemini.GeminiResponse;
import syncoder.myfin.service.gemini.Part;

import java.util.List;

@Service
public class GeminiService {
    @Value("${gemini.api.url}")
    private String geminiApiUrl;
    @Value("${gemini.api.key}")
    private String geminiApiKey;

    private final WebClient webClient;
    private final LoanService loanService;

    @Autowired
    public GeminiService(WebClient.Builder webClientBuilder, LoanService loanService) {
        this.webClient = webClientBuilder.build();
        this.loanService = loanService;
    }

    public String getChatResponse(String promptRequest) {
        Content content = Content.builder()
                .parts(List.of(new Part(promptRequest)))
                .build();
        GeminiRequest geminiRequest = new GeminiRequest(List.of(content));

        GeminiResponse response = webClient.post()
                .uri(geminiApiUrl + geminiApiKey)
                .header("Content-Type", "application/json")
                .bodyValue(geminiRequest)
                .retrieve()
                .bodyToMono(GeminiResponse.class)
                .block();

        return response.getCandidates().getFirst().getContent().getParts().getFirst().getText();
    }


    public String ask(String promptRequest) {
        StringBuilder builder = new StringBuilder();
        builder.append(loanService.getAll());
        builder.append("\n\n").append(promptRequest);
        builder.append("O'zbek tilida javob ber!");
        return getChatResponse(builder.toString());
    }
}
