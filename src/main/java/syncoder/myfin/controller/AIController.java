package syncoder.myfin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import syncoder.myfin.service.impl.GeminiService;

@RestController
@RequestMapping("/chat-bot")
@RequiredArgsConstructor
public class AIController {

    private final GeminiService geminiService;

    @PostMapping("/ask")
    public ResponseEntity<?> askGemini(@RequestParam String request) {
        return ResponseEntity.ok(geminiService.ask(request));
    }
}
