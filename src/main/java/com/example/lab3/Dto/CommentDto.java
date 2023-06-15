package com.example.lab3.Dto;

import com.example.lab3.Entity.TaskEntity;
import com.example.lab3.Entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {
    private String id;
    private Date createDate;
    private Date editDate;
    private String user;
    private List<TaskDto> tasks;
    private String text;

    public CommentDto(String id, Date createDate, Date editDate, UserDto userDto, List<TaskDto> tasks, String text) {
    }
}
