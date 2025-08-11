package com.example.to_do_app.Controllers;

import com.example.to_do_app.Models.Task;
import com.example.to_do_app.Services.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {

    private final TaskService taskService;

    public MainController(TaskService taskService)
    {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String home(Model model)
    {
        List<Task> tasks = taskService.getAllTasks();

        model.addAttribute("tasks",tasks);
        return "index.html";
    }

    @PostMapping("/")
    public String addTask(@RequestParam String description,Model model)
    {
        Task task = new Task();
        task.setDescription(description);
        taskService.addTask(task);

        List<Task> tasks = taskService.getAllTasks();

        model.addAttribute("tasks",tasks);

        return "index.html";
    }

    @PostMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id)
    {
        taskService.deleteTask(id);
        return "redirect:/";
    }

    @PostMapping("/edit/{id}")
    public String editTask(@PathVariable Long id, @RequestParam String description)
    {
        taskService.editTask(description,id);
        return "redirect:/";
    }

}
