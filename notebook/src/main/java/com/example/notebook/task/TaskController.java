package com.example.notebook.task;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/task")
@RequiredArgsConstructor
@RestController
public class TaskController {
    private final TaskService taskService;
    // в реальній розробці не використовують System.out.println(),
    // а використовують Logger для виводу інформації в консоль
    //private static final Logger logger = LoggerFactory.getLogger(NoteService.class);
    @GetMapping("/tasks")
    public ModelAndView viewTasks() {
        ModelAndView result = new ModelAndView("tasks");
        List<Task> tasks = taskService.listAll();
        result.addObject("tasks", tasks);
        return result; // Це відповідає імені файлу шаблону tasks.html
    }
    @PostMapping(value = "/create")
    //використовується анотація @ModelAttribute, щоб отримати дані з форми.
    public String createTask(@ModelAttribute Task task){
        taskService.add(task);
        return "redirect:/task/tasks";
    }

    @DeleteMapping(value = "/delete")
    public String deleteById(@RequestParam(name = "id") long id){
        taskService.deleteById(id);
        return "redirect:/task/tasks";
    }

    @GetMapping(value = "/edit")
    public ModelAndView editNote(@RequestParam(name = "id") long id) {
        Task existingNote = taskService.getById(id);
        if (existingNote == null) {
            return new ModelAndView("redirect:/task/tasks");
        }
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("task", existingNote);
        return modelAndView;
    }


    //OR @PostMapping for update
    @PutMapping("/edit")
    public String editTask(@ModelAttribute Task task) {
        taskService.update(task);
        return "redirect:/task/tasks";
    }
}




