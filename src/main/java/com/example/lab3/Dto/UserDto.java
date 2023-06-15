package com.example.lab3.Dto;

import com.example.lab3.Entity.CommentEntity;
import com.example.lab3.Entity.Role;
import com.example.lab3.Entity.TaskEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String id;
    private Date createDate;
    private Date editDate;
    private String fullName;
    private String login;
    private String password;
    private Role role;
    private List<CommentDto> comments;
    private List<TaskDto> createdTasks;
    private List<TaskDto> tasksInProgress;


    public UserDto(String id, Date createDate, Date editDate, String fullName, String login, String password, Role role) {
    }
}
