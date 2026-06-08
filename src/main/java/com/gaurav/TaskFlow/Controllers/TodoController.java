package com.gaurav.TaskFlow.Controllers;

import com.gaurav.TaskFlow.Entity.Status;
import com.gaurav.TaskFlow.Entity.TodoEntity;
import com.gaurav.TaskFlow.Service.TodoService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private static final Logger logger = LoggerFactory.getLogger(TodoController.class);

    @Autowired
    private TodoService todoService;

    //------------------------------------------------------Create-----------------------------------------------------------
    @PostMapping
    public ResponseEntity<TodoEntity> createTodo(@Valid @RequestBody TodoEntity todoEntity) {
        TodoEntity created = todoService.createTodo(todoEntity);
        logger.info("Todo created with id: {}", created.getId());
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    //------------------------------------------------------Get All-----------------------------------------------------------
    @GetMapping
    public ResponseEntity<List<TodoEntity>> getAllTodos() {
        List<TodoEntity> todos = todoService.getAllTodos();
        logger.info("Fetched {} todos", todos.size());
        return ResponseEntity.ok(todos);
    }

    //------------------------------------------------------Get By Id-----------------------------------------------------------
    @GetMapping("/{id}")
    public ResponseEntity<TodoEntity> getTodoById(@PathVariable int id) {
        TodoEntity todo = todoService.getTodoById(id);
        logger.info("Fetched todo with id: {}", id);
        return ResponseEntity.ok(todo);
    }

    //------------------------------------------------------Get By Status-----------------------------------------------------------

    @GetMapping("/status/{status}")
    public ResponseEntity<List<TodoEntity>> getTodosByStatus(@PathVariable Status status) {
        List<TodoEntity> todos = todoService.getTodosByStatus(status);
        return ResponseEntity.ok(todos);
    }

    //------------------------------------------------------Update-----------------------------------------------------------
    @PutMapping("/{id}")
    public ResponseEntity<TodoEntity> updateTodo(@PathVariable int id,@Valid @RequestBody TodoEntity todoEntity) {
        TodoEntity updated = todoService.updateTodo(id, todoEntity);
        logger.info("Updated todo with id: {}", id);
        return ResponseEntity.ok(updated);
    }

    //------------------------------------------------------Delete-----------------------------------------------------------
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable int id) {
        todoService.deleteTodo(id);
        logger.info("Deleted todo with id: {}", id);
        return ResponseEntity.noContent().build();
    }
}