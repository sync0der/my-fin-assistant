package syncoder.myfin.service;

import syncoder.myfin.dto.ExpensesCategoryDto;
import syncoder.myfin.entity.ExpensesCategory;

import java.util.List;

public interface ExpensesCategoryService {
    ExpensesCategory find(String name);

    void create(String name);

    List<ExpensesCategoryDto> getStats();
}
