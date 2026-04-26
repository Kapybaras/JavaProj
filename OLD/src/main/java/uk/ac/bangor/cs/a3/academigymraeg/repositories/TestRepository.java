package uk.ac.bangor.cs.a3.academigymraeg.repositories;

import uk.ac.bangor.cs.a3.academigymraeg.models.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {
    List<Test> findByUsername(String username);
}