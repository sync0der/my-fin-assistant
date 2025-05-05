package syncoder.myfin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import syncoder.myfin.dto.RequestLoanDto;
import syncoder.myfin.service.LoanService;

@RestController
@RequestMapping("loan")
@RequiredArgsConstructor
public class LoanController {

    private final LoanService loanService;

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody RequestLoanDto loanDto) {
        return ResponseEntity.ok(loanService.create(loanDto));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(loanService.getAll());
    }

    @GetMapping("/get")
    public ResponseEntity<?> add(@RequestParam(name = "type") String type) {
        return ResponseEntity.ok(loanService.getByLoanType(type));
    }
}
