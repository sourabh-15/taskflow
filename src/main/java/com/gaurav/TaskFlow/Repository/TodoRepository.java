package com.gaurav.TaskFlow.Repository;
import com.gaurav.TaskFlow.Entity.Status;
import com.gaurav.TaskFlow.Entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<TodoEntity, Integer> {
    List<TodoEntity> findByStatus(Status status);
}
