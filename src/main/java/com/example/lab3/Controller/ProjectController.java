package com.example.lab3.Controller;

import com.example.lab3.Dto.CreateUpdateProjectDto;
import com.example.lab3.Dto.CreateUpdateTaskDto;
import com.example.lab3.Dto.ProjectDto;
import com.example.lab3.Dto.TaskDto;
import com.example.lab3.Service.ProjectService;
import com.example.lab3.Service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/project")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping(value = "/{id}")
    public ProjectDto getProject(@PathVariable String id) {
        return projectService.getProjectDtoById(id);
    }

    @PostMapping
    public ProjectDto createProject(@RequestBody CreateUpdateProjectDto createUpdateProjectDto) {
        return projectService.createProject(createUpdateProjectDto);
    }
}
