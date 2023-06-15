package com.example.lab3.Dto;

import com.example.lab3.Entity.Priority;
import com.example.lab3.Entity.ProjectEntity;
import com.example.lab3.Entity.UserEntity;
import lombok.Data;

import java.util.Date;
@Data
public class CreateUpdateTaskDto {
    private Date createDate;
    private Date editDate;
    private String header;
    private String description;
    private String creator_id;
    private String executor_id;
    private Priority priority;
    private String project_id;
    private String timeEstimate;
}
