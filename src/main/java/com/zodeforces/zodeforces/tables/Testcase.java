package com.zodeforces.zodeforces.tables;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "testcase")
public class Testcase {
    @Id
    @SequenceGenerator(
            name = "testcase_sequence",
            sequenceName = "testcase_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "testcase_sequence"
    )
    private Long id;

    private String input;
    private String output;

    @ManyToOne
    @JoinColumn(name = "problem_id", referencedColumnName = "id", nullable = false)
    private Problem problem;

    @JsonIgnore
    @OneToMany(mappedBy = "wrongTestcase", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Submit> submits;

    public Testcase() {
    }

    public Testcase(String input, String output, Problem problem) {
        this.input = input;
        this.output = output;
        this.problem = problem;
    }

    public Long getId() {
        return id;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public Problem getProblem() {
        return problem;
    }
}
