package syncoder.myfin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import syncoder.myfin.entity.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {
}
