package syncoder.myfin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import syncoder.myfin.dto.ContactPaymentRequestDto;
import syncoder.myfin.dto.ExpensesDto;
import syncoder.myfin.service.ExpensesCategoryService;
import syncoder.myfin.service.ExpensesService;

@RestController
@RequestMapping("expenses")
@RequiredArgsConstructor
public class ExpensesController {

    private final ExpensesService expensesService;
    private final ExpensesCategoryService expensesCategoryService;

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody ExpensesDto expensesDto) {
        return ResponseEntity.ok(expensesService.paymentFromCashCard(expensesDto));
    }

    @GetMapping("/categories/statistics/get")
    public ResponseEntity<?> getStats() {
        return ResponseEntity.ok(expensesCategoryService.getStats());
    }

//    @PostMapping("/toContact")
//    public ResponseEntity<?> paymentToContact(@RequestParam String cardNumber, @RequestParam double amount) {
//        return ResponseEntity.ok(expensesService.paymentToCard(cardNumber, amount));
//    }

    @PostMapping("/toContact")
    public ResponseEntity<?> paymentToContact(@RequestBody ContactPaymentRequestDto requestDto) {
        return ResponseEntity.ok(expensesService.paymentToCard(requestDto));
    }

    @GetMapping("/card/{id}/get")
    public ResponseEntity<?> getCardExpenses(@PathVariable Long id){
        return ResponseEntity.ok(expensesService.getAll(id));
    }
}
