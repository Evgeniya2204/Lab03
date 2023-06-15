package com.example.lab3.Repository;

import com.example.lab3.Entity.ProjectEntity;
import com.example.lab3.Entity.TaskEntity;
import com.example.lab3.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<TaskEntity, String> {
    List<TaskEntity> findByProject(ProjectEntity projectEntity);
    List<TaskEntity> findByExecutor(UserEntity executor);

}
