package com.example.notebook.user;

import com.example.notebook.task.Task;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Table(name = "person")
@Entity
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;

    @Column
    private String email;

    @OneToMany(mappedBy = "person")
    private List<Task> tasks;
}
