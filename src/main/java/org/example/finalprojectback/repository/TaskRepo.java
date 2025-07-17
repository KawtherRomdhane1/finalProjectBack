package org.example.finalprojectback.repository;

import org.example.finalprojectback.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<Task, Long> {
}
