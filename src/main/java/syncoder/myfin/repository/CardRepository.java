package syncoder.myfin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import syncoder.myfin.entity.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, String> {
}
