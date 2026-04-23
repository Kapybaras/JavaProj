package uk.ac.bangor.cs.a3.academigymraeg.repositories;

import uk.ac.bangor.cs.a3.academigymraeg.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}