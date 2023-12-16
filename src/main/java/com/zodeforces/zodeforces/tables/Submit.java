package com.zodeforces.zodeforces.tables;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "submit")
public class Submit {
    @Id
    @SequenceGenerator(
            name = "submit_sequence",
            sequenceName = "submit_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "submit_sequence"
    )
    private Long id;

    private String language;
    private Double time;
    private Double memory;
    private LocalDate sentDate;
    private LocalDate judgeDate;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "userName", nullable = false)
    private User author;

    @ManyToOne
    @JoinColumn(name = "wrong_testcase_id", referencedColumnName = "id", nullable = false)
    private Testcase wrongTestcase;

    @ManyToOne
    @JoinColumn(name = "problem_id", referencedColumnName = "id", nullable = false)
    private Problem problem;

    public Submit() {
    }

    public Submit(String language,
                  Double time,
                  Double memory,
                  LocalDate sentDate,
                  LocalDate judgeDate,
                  User author,
                  Testcase wrongTestcase,
                  Problem problem) {
        this.language = language;
        this.time = time;
        this.memory = memory;
        this.sentDate = sentDate;
        this.judgeDate = judgeDate;
        this.author = author;
        this.wrongTestcase = wrongTestcase;
        this.problem = problem;
    }

    public Long getId() {
        return id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }

    public Double getMemory() {
        return memory;
    }

    public void setMemory(Double memory) {
        this.memory = memory;
    }

    public LocalDate getSentDate() {
        return sentDate;
    }

    public void setSentDate(LocalDate sentDate) {
        this.sentDate = sentDate;
    }

    public LocalDate getJudgeDate() {
        return judgeDate;
    }

    public void setJudgeDate(LocalDate judgeDate) {
        this.judgeDate = judgeDate;
    }

    public User getAuthor() {
        return author;
    }

    public Testcase getWrong_testcase() {
        return wrongTestcase;
    }

    public void setWrong_testcase(Testcase wrongTestcase) {
        this.wrongTestcase = wrongTestcase;
    }

    public Problem getProblem() {
        return problem;
    }
}
