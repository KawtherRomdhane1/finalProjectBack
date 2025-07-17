package org.example.finalprojectback.service;


import org.example.finalprojectback.entity.Task;

import java.util.List;

public interface TaskService {

    List<Task> getAllTask();

    Task createTask(Task task);

    Task updateTask(Long id, Task task);

    Task getTaskById(Long id);

    void deleteTask(Long id);
}


