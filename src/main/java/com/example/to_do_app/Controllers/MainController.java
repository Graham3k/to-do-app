package com.example.to_do_app.Controllers;

import com.example.to_do_app.Models.Task;
import com.example.to_do_app.Services.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MainController {

    private final TaskService taskService;

    public MainController(TaskService taskService)
    {
        this.taskService = taskService;
    }

    @RequestMapping("/")
    public String home(Model model)
    {
        List<Task> tasks = taskService.getAllTasks();

        model.addAttribute("tasks",tasks);
        return "index.html";
    }

}
