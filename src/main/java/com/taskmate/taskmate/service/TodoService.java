package com.taskmate.taskmate.service;

import com.taskmate.taskmate.entity.Todo;
import com.taskmate.taskmate.repository.TodoRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    // Add a todo
    public Todo addTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    // Get todos for a specific date
    public List<Todo> getTodosByDate(LocalDate date) {
        return todoRepository.findByDate(date);
    }

    // Get todos for a date range
    public List<Todo> getTodosByDateRange(LocalDate startDate, LocalDate endDate) {
        return todoRepository.findByDateBetween(startDate, endDate);
    }

    // Delete a todo
    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }

    // Toggle the completed status of a todo
    public Todo toggleTodoCompleted(Long id) {
        Optional<Todo> todoOptional = todoRepository.findById(id);
        if (todoOptional.isPresent()) {
            Todo todo = todoOptional.get();
            todo.toggleCompleted();
            return todoRepository.save(todo);
        } else {
            throw new RuntimeException("Todo not found with id " + id);
        }
    }
}