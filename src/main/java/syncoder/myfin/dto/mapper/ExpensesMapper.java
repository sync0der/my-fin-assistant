package syncoder.myfin.dto.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import syncoder.myfin.dto.ExpensesDto;
import syncoder.myfin.entity.Expenses;
import syncoder.myfin.service.ExpensesCategoryService;

@Component
@RequiredArgsConstructor
public class ExpensesMapper implements MapperInterface<Expenses, ExpensesDto> {
    private final ExpensesCategoryService expensesCategoryService;

    @Override
    public ExpensesDto toDto(Expenses expenses) {
        return ExpensesDto.builder()
                .amount(expenses.getAmount())
                .categoryName(expenses.getCategory().getName())
                .build();
    }

    @Override
    public Expenses toEntity(ExpensesDto expensesDto) {
        return Expenses.builder()
                .amount(expensesDto.getAmount())
                .category(expensesCategoryService.find(expensesDto.getCategoryName()))
                .build();
    }
}
