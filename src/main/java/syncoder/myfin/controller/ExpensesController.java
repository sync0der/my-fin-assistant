package syncoder.myfin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
        return ResponseEntity.ok(expensesService.add(expensesDto));
    }

    @GetMapping("/categories/statistics/get")
    public ResponseEntity<?> getStats() {
        return ResponseEntity.ok(expensesCategoryService.getStats());
    }
}
