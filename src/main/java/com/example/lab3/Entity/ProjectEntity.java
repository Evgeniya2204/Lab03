package com.example.lab3.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "Projects")
@NoArgsConstructor
@AllArgsConstructor
public class ProjectEntity {
    @Id
    @Column
    private String id;
    @Temporal(TemporalType.DATE)
    @Column(name = "create_date")
    private Date createDate;
    @Temporal(TemporalType.DATE)
    @Column(name = "edit_date")
    private Date editDate;
    @Column
    //@NonNull
    private String name;
    @Column
    //@NonNull
    private String description;
    @OneToMany(mappedBy = "project")
    private List<TaskEntity> tasks;
}
