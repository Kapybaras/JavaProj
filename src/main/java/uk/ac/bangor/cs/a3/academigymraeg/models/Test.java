package uk.ac.bangor.cs.a3.academigymraeg.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "test")
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private LocalDateTime dateTaken;
    private int score;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "test_id")
    private List<TestResult> details;

    public Test() {
        this.dateTaken = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public LocalDateTime getDateTaken() { return dateTaken; }
    public void setDateTaken(LocalDateTime dateTaken) { this.dateTaken = dateTaken; }
    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }
    public List<TestResult> getDetails() { return details; }
    public void setDetails(List<TestResult> details) { this.details = details; }
}