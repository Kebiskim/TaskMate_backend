package com.taskmate.taskmate.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title; // Todo title
    private String description; // Todo description

    @Column(nullable = false)
    private LocalDate date; // Date (user-selected date)

    private boolean completed = false; // Completion status (default: false)

    @Column(length = 32)
    private String importance; // Importance level (low, middle, high)

    public void toggleCompleted() {
        this.completed = !this.completed;
    }
}