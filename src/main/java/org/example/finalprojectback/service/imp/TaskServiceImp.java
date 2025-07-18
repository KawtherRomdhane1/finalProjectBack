package org.example.finalprojectback.service.imp;

import jakarta.persistence.EntityNotFoundException;
import org.example.finalprojectback.entity.Task;
import org.example.finalprojectback.repository.TaskRepo;
import org.example.finalprojectback.service.TaskService;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class TaskServiceImp implements TaskService {

    private final TaskRepo taskRepo;

    public TaskServiceImp(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;

    }
    @Override
    public Task createTask(Task task) {
        return taskRepo.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepo.findAll();
    }
    public Task getTaskById(Long id) {
        return taskRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tâche non trouvée avec l'ID : " + id));
    }


    public Task updateTask(Long id, Task updatedTask) {

        Task existingTask = getTaskById(id);
        existingTask.setContent(updatedTask.getContent());
        existingTask.setTitle(updatedTask.getTitle());
        return taskRepo.save(existingTask);

    }


    public void deleteTask(Long id) {
        if (!taskRepo.existsById(id)) {
            throw new EntityNotFoundException("Tâche non trouvée avec l'ID : " + id);
        }
        taskRepo.deleteById(id);
    }
    }


