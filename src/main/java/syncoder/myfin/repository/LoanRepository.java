package syncoder.myfin.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import syncoder.myfin.entity.Loan;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
    @EntityGraph(attributePaths = {"bank"})
    List<Loan> findAllByType(String type);

    @EntityGraph(attributePaths = {"bank"})
    List<Loan> findAll();
}
