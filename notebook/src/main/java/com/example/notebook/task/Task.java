package com.example.notebook.task;

import com.example.notebook.user.Person;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    @Column(name ="date_to_complete")
    private LocalDate dateToComplete;

    @Column
    @Enumerated(EnumType.STRING)// Зберігаємо enum як рядок в базі даних
    private Priority priority;

    @Column
    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
}
