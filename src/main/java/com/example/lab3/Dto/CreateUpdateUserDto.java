package com.example.lab3.Dto;

import com.example.lab3.Entity.Role;
import lombok.Data;

import java.util.Date;

@Data
public class CreateUpdateUserDto {
    private Date createDate;
    private Date editDate;
    private String fullName;
    private String login;
    private String password;
    private Role role;
}
