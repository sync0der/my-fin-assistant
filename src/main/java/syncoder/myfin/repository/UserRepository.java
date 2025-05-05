package syncoder.myfin.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import syncoder.myfin.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    @Query("""
            SELECT u from User u
            LEFT JOIN FETCH u.cards c
            LEFT JOIN FETCH c.expenses
            WHERE  u.id = :id
            """)
    User get(Long id);
}
