package com.taskmate.taskmate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.taskmate.taskmate.entity.Todo;
import java.time.LocalDate;
import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findByDate(LocalDate date);
    List<Todo> findByDateBetween(LocalDate startDate, LocalDate endDate);
}