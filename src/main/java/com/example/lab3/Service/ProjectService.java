package com.example.lab3.Service;

import com.example.lab3.Converter.TaskDtoConverter;
import com.example.lab3.Dto.CreateUpdateProjectDto;
import com.example.lab3.Dto.ProjectDto;
import com.example.lab3.Entity.ProjectEntity;
import com.example.lab3.Exception.TaskNotFoundException;
import com.example.lab3.Repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;

    @Transactional
    public ProjectDto createProject(CreateUpdateProjectDto projectDto) {

        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setId(UUID.randomUUID().toString());
        projectEntity.setCreateDate(projectDto.getCreateDate());
        projectEntity.setEditDate(projectDto.getEditDate());
        projectEntity.setName(projectDto.getName());
        projectEntity.setDescription(projectDto.getDescription());
        var savedEntity = projectRepository.save(projectEntity);
        return new ProjectDto(
                savedEntity.getId(),
                savedEntity.getCreateDate(),
                savedEntity.getEditDate(),
                savedEntity.getName(),
                savedEntity.getDescription(),
                TaskDtoConverter.convertTasksToDto(savedEntity.getTasks())
        );
    }

    @Transactional(readOnly = true)
    public ProjectEntity getProjectEntityById(String projectId) {
        return projectRepository.findById(projectId)
                .orElseThrow(() -> new TaskNotFoundException("Проект с id " + projectId + " не найден"));
    }

    @Transactional
    public ProjectDto getProjectDtoById(String projectId) {
        ProjectEntity projectEntity = getProjectEntityById(projectId);
        return new ProjectDto(
                projectEntity.getId(),
                projectEntity.getCreateDate(),
                projectEntity.getEditDate(),
                projectEntity.getName(),
                projectEntity.getDescription(),
                TaskDtoConverter.convertTasksToDto(projectEntity.getTasks())
        );
    }
}
