package syncoder.myfin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import syncoder.myfin.dto.BankDto;
import syncoder.myfin.entity.ExchangeRates;
import syncoder.myfin.service.BankService;

import java.util.List;

@RestController
@RequestMapping("bank")
@RequiredArgsConstructor
public class BankController {

    private final BankService bankService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody BankDto bankDto) {
        return ResponseEntity.ok(bankService.create(bankDto));
    }

    @PostMapping("/{id}/set-image")
    public ResponseEntity<?> setImage(@PathVariable Long id, @RequestParam(name = "image") MultipartFile file) {
        return ResponseEntity.ok(bankService.setImage(id, file));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(bankService.getAll());
    }

    @PostMapping("/{id}/update")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody BankDto updateDto) {
        return ResponseEntity.ok(bankService.update(id, updateDto));
    }


    @PostMapping("/{id}/set-exchange-rate")
    public ResponseEntity<?> setExchangeRate(@PathVariable Long id, @RequestBody List<ExchangeRates> exchangeRates){
        return ResponseEntity.ok(bankService.setExchangeRate(id, exchangeRates));
    }


}
