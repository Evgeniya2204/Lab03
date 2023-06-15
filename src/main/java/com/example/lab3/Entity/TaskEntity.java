package com.example.lab3.Entity;

import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "Tasks")
@NoArgsConstructor
@AllArgsConstructor
public class TaskEntity {
    @Id
    @Column
    private String id;
    @Temporal(TemporalType.DATE)
    @Column(name = "create_date")
    private Date createDate;
    @Temporal(TemporalType.DATE)
    @Column(name = "edit_date")
    private Date editDate;
    //@NonNull
    @Column
    private String header;
    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "creator_id", referencedColumnName = "id")
    private UserEntity creator;
    @ManyToOne
    @JoinColumn(name = "executor_id", referencedColumnName = "id")
    private UserEntity executor;
    @Enumerated(EnumType.STRING)
    @Column
    private Priority priority;
    @ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    private ProjectEntity project;
    @Column(name = "time_estimate")
    private String timeEstimate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "comment_task",
            joinColumns = @JoinColumn(name = "task_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "comment_id", referencedColumnName = "id"))
    private List<CommentEntity> comments;

}
