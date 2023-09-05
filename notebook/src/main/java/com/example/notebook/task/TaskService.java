package com.example.notebook.task;

import com.example.notebook.task.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TaskService implements ITaskService {
    private final TaskRepository repository;

    @Override
    public Task add(Task task) {
        return repository.save(task);
    }

    @Override
    public Task getById(long id) {
        Optional<Task> noteOptional = repository.findById(id);
        return noteOptional.orElseThrow(() -> new NoSuchElementException("Note not found!"));
    }

    @Override
    public List<Task> listAll() {
        return repository.findAll();
    }

    @Override
    public void update(Task task) {
        repository.save(task);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
