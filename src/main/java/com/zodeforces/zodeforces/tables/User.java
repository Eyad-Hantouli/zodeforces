package com.zodeforces.zodeforces.tables;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "uers")
public class User {
    @Id
    private String userName;

    @Column(unique = true)
    private String email;
    private String password;
    private String fullName;
    private LocalDate dob;
    private LocalDate creationDate;

    public User() {
    }

    public User(UserBuilder builder) {
        this.userName = builder.userName;
        this.email = builder.email;
        this.password = builder.password;
        this.fullName = builder.fullName;
        this.dob = builder.dob;
        this.creationDate = builder.creationDate;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Submit> submits;

    public static class UserBuilder {
        // Required fields
        private String userName;
        private String email;
        private String password;
        private String fullName;
        private LocalDate creationDate;

        // Optional fields
        private LocalDate dob;

        public UserBuilder(String userName,
                           String email,
                           String password,
                           String fullName,
                           LocalDate creationDate) {
            this.userName = userName;
            this.email = email;
            this.password = password;
            this.fullName = fullName;
            this.creationDate = creationDate;
        }

        public UserBuilder setDob(LocalDate dob) {
            this.dob = dob;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
