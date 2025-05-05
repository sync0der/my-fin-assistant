package syncoder.myfin.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import syncoder.myfin.dto.ExpensesCategoryDto;
import syncoder.myfin.dto.mapper.ExpensesCategoryMapper;
import syncoder.myfin.entity.Card;
import syncoder.myfin.entity.ExpensesCategory;
import syncoder.myfin.repository.CardRepository;
import syncoder.myfin.repository.ExpensesCategoryRepository;
import syncoder.myfin.service.ExpensesCategoryService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpensesCategoryServiceImpl implements ExpensesCategoryService {

    private final ExpensesCategoryRepository expensesCategoryRepository;
    private final CardRepository cardRepository;
    private final ExpensesCategoryMapper expensesCategoryMapper;

    @Override
    public ExpensesCategory find(String name) {
        return expensesCategoryRepository.findByName(name);
    }

    @Override
    public void create(String name) {
        expensesCategoryRepository.save(ExpensesCategory.builder().name(name).build());
    }

    @Override
    public List<ExpensesCategoryDto> getStats() {
        Card card = cardRepository.findById(2L);

        return expensesCategoryRepository.findAll().stream()
                .map(category -> {
                    calculateAvgPercentage(card, category);
                    return calculateAvgPercentage(card, category);
                }).map(expensesCategoryMapper::toDto)
                .toList();
    }

    private ExpensesCategory calculateAvgPercentage(Card card, ExpensesCategory category) {
        double avgShare = category.getTotalAmount() * 100 / card.getTotalExpense();
        BigDecimal rounded = new BigDecimal(avgShare).setScale(2, RoundingMode.HALF_UP);
        category.setAveragePercentage(rounded.doubleValue());
        return expensesCategoryRepository.save(category);
    }


}
