package com.example.lab3.Converter;


import com.example.lab3.Dto.CreateUpdateTaskDto;
import com.example.lab3.Dto.TaskDto;
import com.example.lab3.Entity.TaskEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskDtoConverter {

    public static TaskEntity convertDtoToEntity(CreateUpdateTaskDto taskDto) {
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setId(UUID.randomUUID().toString());
        taskEntity.setCreateDate(taskDto.getCreateDate());
        taskEntity.setEditDate(taskDto.getEditDate());
        taskEntity.setHeader(taskDto.getHeader());
        taskEntity.setDescription(taskDto.getDescription());
        // taskEntity.setCreator(userRepository.findById(taskDto.getCreator_id()));

        return taskEntity;
    }

    public static TaskDto convertEntityToDto(TaskEntity taskEntity) { //List<CommentEntity> comments){
        TaskDto taskDto = new TaskDto();
        taskDto.setId(taskEntity.getId());
        taskDto.setCreateDate(taskEntity.getCreateDate());
        taskDto.setEditDate(taskEntity.getEditDate());
        taskDto.setHeader(taskEntity.getHeader());
        taskDto.setDescription(taskEntity.getDescription());
        taskDto.setCreator(taskEntity.getCreator().getFullName());
        taskDto.setExecutor(taskEntity.getExecutor().getFullName());
        taskDto.setPriority(taskEntity.getPriority());
        taskDto.setProject(taskEntity.getProject().getName());
        taskDto.setTimeEstimate(taskEntity.getTimeEstimate());
        //taskDto.setComments(convertCommentsToDto(comments));

        return taskDto;
    }

    public static List<TaskDto> convertTasksToDto(List<TaskEntity> taskEntities) {
        List<TaskDto> result = new ArrayList<>();
        taskEntities.forEach(element -> {
            result.add(convertEntityToDto(element));
        });
        return result;
    }
}
