package com.example.notebook.task;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/task")
@RequiredArgsConstructor
@RestController
public class TaskController {
    private final TaskService taskService;
    // в реальній розробці не використовують System.out.println(),
    // а використовують Logger для виводу інформації в консоль
    //private static final Logger logger = LoggerFactory.getLogger(NoteService.class);

    @PostMapping(value = "/create")
    public Task createTask(@RequestBody Task task){
        return taskService.add(task);
    }

    @GetMapping(value = "/list")
    public List<Task> getListOfNotes(){
        return taskService.listAll();
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<String> deleteById(@RequestParam(name = "id") long id){
        Task existingNote = taskService.getById(id);
        if(existingNote == null){
            return ResponseEntity.notFound().build();
        }
        taskService.deleteById(id);
        return ResponseEntity.ok("Task deleted successfully");
        //return "redirect:/note/list";
    }

    @GetMapping(value = "/edit")
    public ResponseEntity<Task> editNote(@RequestParam(name = "id") long id){
        //another variant is to use: @PathVariable Long id
        Task existingNote = taskService.getById(id);
        if (existingNote == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(existingNote);
    }


    //OR @PostMapping for update
    @PutMapping("/edit")
    public ResponseEntity<String> editNote(@RequestBody  Task note){
        Task existingNote = taskService.getById(note.getId());
        if (existingNote == null) {
            return ResponseEntity.notFound().build();
        }
        taskService.update(note);
        return ResponseEntity.ok("Task updated successfully");

    }
}
