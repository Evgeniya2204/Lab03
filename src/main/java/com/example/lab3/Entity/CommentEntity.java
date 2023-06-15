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
@Table(name = "Comments")
@NoArgsConstructor
@AllArgsConstructor
public class CommentEntity {
    @Id
    @Column
    private String id;
    @Temporal(TemporalType.DATE)
    @Column(name = "create_date")
    private Date createDate;
    @Temporal(TemporalType.DATE)
    @Column(name = "edit_date")
    private Date editDate;


    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "comment_task",
    joinColumns = @JoinColumn(name = "comment_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "task_id",referencedColumnName = "id"))
    private List<TaskEntity> tasks;

    @Column
    //@NonNull
    private String text;
}
