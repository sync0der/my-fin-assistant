package syncoder.myfin.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import syncoder.myfin.dto.ExpensesDto;
import syncoder.myfin.dto.mapper.ExpensesMapper;
import syncoder.myfin.entity.Card;
import syncoder.myfin.entity.Expenses;
import syncoder.myfin.entity.ExpensesCategory;
import syncoder.myfin.repository.CardRepository;
import syncoder.myfin.repository.ExpensesCategoryRepository;
import syncoder.myfin.repository.ExpensesRepository;
import syncoder.myfin.service.ExpensesCategoryService;
import syncoder.myfin.service.ExpensesService;

@Service
@RequiredArgsConstructor
public class ExpensesServiceImpl implements ExpensesService {

    private final ExpensesMapper expensesMapper;
    private final CardRepository cardRepository;
    private final ExpensesRepository expensesRepository;
    private final ExpensesCategoryService expensesCategoryService;
    private final ExpensesCategoryRepository expensesCategoryRepository;


    @Override
    public ExpensesDto add(ExpensesDto requestDto) {
        ExpensesCategory category = expensesCategoryService.find(requestDto.getCategoryName());

        Card card = cardRepository.findById(2L);
        double totalExpense = card.getTotalExpense() + requestDto.getAmount();
        card.setTotalExpense(totalExpense);
        cardRepository.save(card);

        Expenses expenses = Expenses.builder()
                .amount(requestDto.getAmount())
                .category(category)
                .card(card)
                .build();
        calculateExpensesCategoryShare(category, requestDto.getAmount(), card.getTotalExpense());
        return expensesMapper.toDto(expensesRepository.save(expenses));
    }

    private void calculateExpensesCategoryShare(ExpensesCategory expensesCategory, double amountToAdd, double totalExpense) {
        double amount = expensesCategory.getTotalAmount() + amountToAdd;
        expensesCategory.setTotalAmount(amount);
        expensesCategoryRepository.save(expensesCategory);
    }


}
