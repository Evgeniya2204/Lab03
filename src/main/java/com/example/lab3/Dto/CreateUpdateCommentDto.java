package com.example.lab3.Dto;

import com.example.lab3.Entity.TaskEntity;
import com.example.lab3.Entity.UserEntity;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CreateUpdateCommentDto {
    private Date createDate;
    private Date editDate;
    private String user_id;
    private String task_id;
    private String text;
}
