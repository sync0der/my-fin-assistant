package syncoder.myfin.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import syncoder.myfin.entity.Bank;

import java.util.List;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {

    @Query("""
            SELECT b from Bank b
            LEFT JOIN FETCH b.exchangeRates
            """)
    List<Bank> findAllBanks();

    @EntityGraph(attributePaths = {"exchangeRates"})
    Bank findBankById(Long id);
}
