package com.example.notebook.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RequiredArgsConstructor
@RestController
public class PersonController {
    private final PersonService personService;

    @GetMapping("/getByEmail")
    public Person getByEmail(@RequestParam(name = "email") String email) {
        return personService.getByEmail(email);
    }

    @PostMapping("/login")
    public Person save(@RequestBody Person person){
        return personService.save(person);
    }


}
