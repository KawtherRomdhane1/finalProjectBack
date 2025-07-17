package org.example.finalprojectback.service.imp;

import jakarta.persistence.EntityNotFoundException;
import org.example.finalprojectback.entity.Task;
import org.example.finalprojectback.repository.TaskRepo;
import org.example.finalprojectback.service.TaskService;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.NoSuchElementException;


@Service
public class TaskServiceImp implements TaskService {

    private final TaskRepo taskRepo;

    public TaskServiceImp(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;

    }
@Override
    public List<Task> getAllTask() {
        return taskRepo.findAll();

    }

    @Override
    public Task createTask(Task task) {
        return taskRepo.save(task);
    }

    @Override
    public Task updateTask(Long id, Task task) {

        Task existingTask = taskRepo.findById(id).get();
        existingTask.setTitle(task.getTitle());
        existingTask.setContent(task.getContent());
        return taskRepo.save(existingTask);

    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tâche non trouvée avec l'ID : " + id));
    }

    @Override
    public void deleteTask(Long id) {
        if (!taskRepo.existsById(id)) {
            throw new NoSuchElementException("Tâche non trouvée avec l'ID : " + id);
        }
        taskRepo.deleteById(id);
    }
    }


