package syncoder.myfin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import syncoder.myfin.dto.CardDto;
import syncoder.myfin.service.CardService;

@RestController
@RequestMapping("card")
@RequiredArgsConstructor
public class CardController {


    private final CardService cardService;

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestParam(name = "user") Long userId, @RequestBody CardDto cardDto) {
        return ResponseEntity.ok(cardService.createCard(userId, cardDto));
    }
}
