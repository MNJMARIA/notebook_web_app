package com.example.notebook.task;

import java.util.List;

public interface ITaskService {
    Task add(Task task);
    Task getById(long id);
    List<Task> listAll();
    void update(Task note);
    void deleteById(long id);
}
