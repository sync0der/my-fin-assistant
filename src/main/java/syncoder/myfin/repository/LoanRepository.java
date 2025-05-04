package syncoder.myfin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import syncoder.myfin.entity.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
}
