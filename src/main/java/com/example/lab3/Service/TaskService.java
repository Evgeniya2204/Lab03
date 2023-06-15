package com.example.lab3.Service;

import com.example.lab3.Converter.TaskDtoConverter;
import com.example.lab3.Dto.CreateUpdateTaskDto;
import com.example.lab3.Dto.TaskDto;
import com.example.lab3.Entity.ProjectEntity;
import com.example.lab3.Entity.TaskEntity;
import com.example.lab3.Entity.UserEntity;
import com.example.lab3.Exception.TaskNotFoundException;
import com.example.lab3.Repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    @Transactional
    public TaskDto createTask(CreateUpdateTaskDto taskDto) {
        TaskEntity taskEntity = TaskDtoConverter.convertDtoToEntity(taskDto);
        taskEntity = taskRepository.save(taskEntity);
        return TaskDtoConverter.convertEntityToDto(taskEntity);
    }

    @Transactional(readOnly = true)
    public TaskEntity getTaskEntityById(String id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Задача с id " + id + " не найдена"));
    }

    @Transactional(readOnly = true)
    public TaskDto getTaskDtoById(String id) {
        TaskEntity taskEntity = getTaskEntityById(id);
        return TaskDtoConverter.convertEntityToDto(taskEntity);
    }

    public List<TaskEntity> getTasksByProject (ProjectEntity projectEntity){
        return taskRepository.findByProject(projectEntity);
    }
    public List<TaskEntity> getTasksByExecutor(UserEntity executor){
        return taskRepository.findByExecutor(executor);
    }
}
