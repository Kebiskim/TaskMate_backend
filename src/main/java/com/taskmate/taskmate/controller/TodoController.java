package com.taskmate.taskmate.controller;

import com.taskmate.taskmate.entity.Todo;
import com.taskmate.taskmate.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin(origins = "${cors.allowed.origins}") // Allow CORS for frontend
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    // Add a todo
    @PostMapping
    public ResponseEntity<Todo> addTodo(@RequestBody Todo todo) {
        Todo savedTodo = todoService.addTodo(todo);
        return ResponseEntity.ok(savedTodo);
    }

    // Get todos for a specific date
    @GetMapping("/{date}")
    public ResponseEntity<List<Todo>> getTodosByDate(@PathVariable("date") String date) {
        LocalDate localDate = LocalDate.parse(date);
        List<Todo> todos = todoService.getTodosByDate(localDate);
        return ResponseEntity.ok(todos);
    }

    // Get todos for a date range
    @GetMapping
    public ResponseEntity<List<Todo>> getTodosByDateRange(@RequestParam("start") String start, @RequestParam("end") String end) {
        LocalDate startDate = LocalDate.parse(start);
        LocalDate endDate = LocalDate.parse(end);
        List<Todo> todos = todoService.getTodosByDateRange(startDate, endDate);
        return ResponseEntity.ok(todos);
    }

    // Delete a todo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable("id") Long id) {
        todoService.deleteTodo(id);
        return ResponseEntity.noContent().build();
    }

    // Toggle the completed status of a todo
    @PatchMapping("/{id}/toggle")
    public ResponseEntity<Todo> toggleTodoCompleted(@PathVariable("id") Long id) {
        Todo updatedTodo = todoService.toggleTodoCompleted(id);
        return ResponseEntity.ok(updatedTodo);
    }

    // Update the importance of a todo
    @PatchMapping("/{id}/changeimportance")
    public ResponseEntity<Todo> updateTodoImportance(@PathVariable("id") Long id, @RequestParam("importance") String importance) {
        Todo updatedTodo = todoService.updateTodoImportance(id, importance);
        return ResponseEntity.ok(updatedTodo);
    }
}