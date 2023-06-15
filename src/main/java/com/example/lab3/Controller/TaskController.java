package com.example.lab3.Controller;

import com.example.lab3.Dto.CreateUpdateTaskDto;
import com.example.lab3.Dto.TaskDto;
import com.example.lab3.Service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping(value = "/{id}")
    public TaskDto getTask(@PathVariable String id) {
        return taskService.getTaskDtoById(id);
    }

    @PostMapping
    public TaskDto createTask(@RequestBody CreateUpdateTaskDto createUpdateTaskDto) {
        return taskService.createTask(createUpdateTaskDto);
    }
}
