package com.gaurav.TaskFlow.Service;

import com.gaurav.TaskFlow.Entity.Status;
import com.gaurav.TaskFlow.Entity.TodoEntity;
import java.util.List;

public interface TodoService {

    List<TodoEntity> getAllTodos();

    TodoEntity getTodoById(int id);

    TodoEntity createTodo(TodoEntity todo);

    TodoEntity updateTodo(int id, TodoEntity todo);

    List<TodoEntity> getTodosByStatus(Status status);

    void deleteTodo(int id);
}