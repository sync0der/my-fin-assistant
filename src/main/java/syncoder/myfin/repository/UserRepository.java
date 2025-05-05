package syncoder.myfin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import syncoder.myfin.entity.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
}
