package syncoder.myfin.dto.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import syncoder.myfin.dto.ExpensesCategoryDto;
import syncoder.myfin.entity.ExpensesCategory;

@Component
@RequiredArgsConstructor
public class ExpensesCategoryMapper implements MapperInterface<ExpensesCategory, ExpensesCategoryDto> {

    @Override
    public ExpensesCategoryDto toDto(ExpensesCategory expensesCategory) {
        return ExpensesCategoryDto.builder()
                .id(expensesCategory.getId())
                .name(expensesCategory.getName())
                .totalAmount(expensesCategory.getTotalAmount())
                .averagePercentage(expensesCategory.getAveragePercentage())
                .build();
    }
}
