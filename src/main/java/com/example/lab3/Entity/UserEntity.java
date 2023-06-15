package com.example.lab3.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "Users")
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @Column
    private String id;
    @Temporal(TemporalType.DATE)
    @Column(name = "create_date")
    private Date createDate;
    @Temporal(TemporalType.DATE)
    @Column(name = "edit_date")
    private Date editDate;
    @Column(name = "full_name")
    private String fullName;
    @Column
    private String login;
    @Column
    private String password;
    @Enumerated(EnumType.STRING)
    @Column
    private Role role;


    @OneToMany(mappedBy = "user")
    private List<CommentEntity> comments;
    @OneToMany(mappedBy = "creator")
    private List<TaskEntity> createdTasks;
    @OneToMany(mappedBy = "executor")
    private List<TaskEntity> tasksInProgress;

    public UserEntity(String string, Date createDate, Date editDate, String fullName, String login, String password, Role role) {
    }
}
