package com.gaurav.TaskFlow.Service;

import com.gaurav.TaskFlow.Entity.Status;
import com.gaurav.TaskFlow.Entity.TodoEntity;
import com.gaurav.TaskFlow.Exception.ResourceNotFoundException;
import com.gaurav.TaskFlow.Repository.TodoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    private static final Logger logger = LoggerFactory.getLogger(TodoServiceImpl.class);

    @Autowired
    private TodoRepository todoRepository;

    //------------------------------------------------------Create-----------------------------------------------------------
    @Override
    public TodoEntity createTodo(TodoEntity todoEntity) {
        TodoEntity saved = todoRepository.save(todoEntity);
        logger.info("Todo created successfully with id: {}", saved.getId());
        return saved;
    }

    //------------------------------------------------------Get All-----------------------------------------------------------
    @Override
    public List<TodoEntity> getAllTodos() {
        List<TodoEntity> allTodo = todoRepository.findAll();
        logger.info("Total todos fetched: {}", allTodo.size());
        return allTodo;
    }

    //------------------------------------------------------Get By Id-----------------------------------------------------------
    @Override
    public TodoEntity getTodoById(int id) {
        TodoEntity singleTodo = todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo not found with id: " + id));

        logger.info("Fetched todo with id: {}", id);
        return singleTodo;
    }


    //------------------------------------------------------Get By Status-----------------------------------------------------------

    @Override
    public List<TodoEntity> getTodosByStatus(Status status) {
        List<TodoEntity> todos = todoRepository.findByStatus(status);
        if (todos.isEmpty()) {
            throw new ResourceNotFoundException("No todos found with status: " + status);
        }
        logger.info("Fetched {} todos with status {}", todos.size(), status);
        return todos;
    }


    //------------------------------------------------------Update-----------------------------------------------------------
    @Override
    public TodoEntity updateTodo(int id, TodoEntity todoEntity) {

        TodoEntity existing = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found with id: " + id));

        existing.setTitle(todoEntity.getTitle());
        existing.setContent(todoEntity.getContent());
        existing.setStatus(todoEntity.getStatus());
        existing.setDueDate(todoEntity.getDueDate());

        TodoEntity updated = todoRepository.save(existing);
        logger.info("Todo updated successfully with id: {}", id);

        return updated;
    }

    //------------------------------------------------------Delete-----------------------------------------------------------
    @Override
    public void deleteTodo(int id) {

        TodoEntity existing = todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo not found with id: " + id));

        todoRepository.delete(existing);
        logger.info("Todo deleted successfully with id: {}", id);
    }
}