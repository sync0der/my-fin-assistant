package syncoder.myfin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import syncoder.myfin.entity.Expenses;

@Repository
public interface ExpensesRepository extends JpaRepository<Expenses, Long> {
}
