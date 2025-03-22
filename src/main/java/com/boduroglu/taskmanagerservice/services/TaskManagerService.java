package com.boduroglu.taskmanagerservice.services;

import com.boduroglu.taskmanagerservice.models.dtos.requests.TaskCreateRequest;
import com.boduroglu.taskmanagerservice.models.enums.TaskStatus;
import com.boduroglu.taskmanagerservice.models.entities.Task;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class TaskManagerService {
    Map<String, Task> tasks = new HashMap<>();

    // Create
    public Task createTask(TaskCreateRequest taskCreateRequest) {
        Task task = new Task();
        UUID uuid = UUID.randomUUID();

        task.setId(uuid);
        task.setTitle(taskCreateRequest.getTitle());
        task.setDescription(taskCreateRequest.getDescription());
        task.setStatus(TaskStatus.TODO);
        task.setCreatedAt(LocalDateTime.now());
        task.setUpdatedAt(LocalDateTime.now());

        tasks.put(uuid.toString(), task);

        return task;
    }

    // Read
    public Map<String, Task> getTasks() {
        return tasks;
    }
    public Task getTask(String uuid) {
        return tasks.get(uuid);
    }

    // TODO Update


    // TODO Delete
}
