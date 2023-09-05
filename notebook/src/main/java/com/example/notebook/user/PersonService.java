package com.example.notebook.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PersonService {
    private final PersonRepository repository;

    public Person getByEmail(String email) {
        return repository.getByEmail(email);
    }

    public Person save(Person person){
        return repository.save(person);
    }
}
