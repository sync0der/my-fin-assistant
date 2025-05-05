package syncoder.myfin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import syncoder.myfin.entity.ExpensesCategory;

import java.util.List;

@Repository
public interface ExpensesCategoryRepository extends JpaRepository<ExpensesCategory, Long> {
    ExpensesCategory findByName(String name);
}
