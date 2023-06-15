package com.example.lab3.Dto;

import com.example.lab3.Entity.CommentEntity;
import com.example.lab3.Entity.Priority;
import com.example.lab3.Entity.ProjectEntity;
import com.example.lab3.Entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {
    private String id;
    private Date createDate;
    private Date editDate;
    private String header;
    private String description;
    private String creator;
    private String executor;
    private Priority priority;
    private String project;//String or DTO?
    private String timeEstimate;
    private List<CommentDto> comments;
}
