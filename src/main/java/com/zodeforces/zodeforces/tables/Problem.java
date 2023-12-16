package com.zodeforces.zodeforces.tables;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "problem")
public class Problem {
    @Id
    @SequenceGenerator(
            name = "problem_sequence",
            sequenceName = "problem_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "problem_sequence"
    )
    private Long id;
    private Integer hardness;
    private Double timeLimit;
    private Double memoryLimit;
    private String title;
    private String problemDescription;
    private String inputDescription;
    private String outputDescription;
    private String note;
    private LocalDate publishDate;

    @JsonIgnore
    @OneToMany(mappedBy = "problem", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Testcase> testcases;

    @JsonIgnore
    @OneToMany(mappedBy = "problem", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Submit> submits;

    public Problem() {
    }

    public Problem(ProblemBuilder builder) {
        this.hardness = builder.hardness;
        this.timeLimit = builder.timeLimit;
        this.memoryLimit = builder.memoryLimit;
        this.title = builder.title;
        this.problemDescription = builder.problemDescription;
        this.inputDescription = builder.inputDescription;
        this.outputDescription = builder.outputDescription;
        this.note = builder.note;
        this.publishDate = builder.publishDate;
    }

    public Long getId() {
        return id;
    }

    public Integer getHardness() {
        return hardness;
    }

    public void setHardness(Integer hardness) {
        this.hardness = hardness;
    }

    public Double getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(Double timeLimit) {
        this.timeLimit = timeLimit;
    }

    public Double getMemoryLimit() {
        return memoryLimit;
    }

    public void setMemoryLimit(Double memoryLimit) {
        this.memoryLimit = memoryLimit;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }

    public String getInputDescription() {
        return inputDescription;
    }

    public void setInputDescription(String inputDescription) {
        this.inputDescription = inputDescription;
    }

    public String getOutputDescription() {
        return outputDescription;
    }

    public void setOutputDescription(String outputDescription) {
        this.outputDescription = outputDescription;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public static class ProblemBuilder {
        // Required fields
        private Integer hardness;
        private Double timeLimit;
        private Double memoryLimit;
        private String title;
        private String problemDescription;
        private LocalDate publishDate;

        // Optional fields
        private String inputDescription;
        private String outputDescription;
        private String note;

        public ProblemBuilder(Integer hardness,
                              Double timeLimit,
                              Double memoryLimit,
                              String title,
                              String problemDescription,
                              LocalDate publishDate) {
            this.hardness = hardness;
            this.timeLimit = timeLimit;
            this.memoryLimit = memoryLimit;
            this.title = title;
            this.problemDescription = problemDescription;
            this.publishDate = publishDate;
        }

        public ProblemBuilder setInputDescription(String inputDescription) {
            this.inputDescription = inputDescription;
            return this;
        }

        public ProblemBuilder setOutputDescription(String outputDescription) {
            this.outputDescription = outputDescription;
            return this;
        }

        public ProblemBuilder setNote(String note) {
            this.note = note;
            return this;
        }

        public Problem build() {
            return new Problem(this);
        }
    }
}
