package com.example.lab3.Dto;

import lombok.Data;

import java.util.Date;

@Data
public class CreateUpdateProjectDto {
    private Date createDate;
    private Date editDate;
    private String name;
    private String description;
}
