package uk.ac.bangor.cs.a3.academigymraeg.repositories;

import uk.ac.bangor.cs.a3.academigymraeg.models.Noun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface NounRepository extends JpaRepository<Noun, Long> {
    @Query(value = "SELECT * FROM nouns ORDER BY RAND() LIMIT :limit", nativeQuery = true)
    List<Noun> findRandomNouns(int limit);
}