package com.example.to_do_app.Services;

import com.example.to_do_app.Models.Task;
import com.example.to_do_app.Repositories.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository)
    {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks()
    {
        return taskRepository.findAll();
    }

    @Transactional
    public void addTask(Task task)
    {
        taskRepository.save(task);
    }

    @Transactional
    public void deleteTask(Long id)
    {
        taskRepository.deleteById(id);
    }

    @Transactional
    public void editTask(String description,Long id)
    {
        taskRepository.update(description,id);
    }

}
