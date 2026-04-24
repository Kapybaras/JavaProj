package uk.ac.bangor.cs.a3.academigymraeg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import uk.ac.bangor.cs.a3.academigymraeg.models.Test;

public interface TestRepository extends JpaRepository<Test, Long> {
}