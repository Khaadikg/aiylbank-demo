package com.aiylbank.demo.model.task.service;

import com.aiylbank.demo.model.common.BaseEntityService;
import com.aiylbank.demo.model.task.dao.TaskStorageService;
import com.aiylbank.demo.model.task.entity.Status;
import com.aiylbank.demo.model.task.entity.Task;
import com.aiylbank.demo.model.task.service.dto.TaskDto;
import com.aiylbank.demo.web.common.exception.NotFoundException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Getter
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskService extends BaseEntityService<Task, TaskDto, Long, TaskStorageService> {

    final TaskStorageService service;

    @Override
    protected Class<TaskDto> getDtoClass() {
        return TaskDto.class;
    }

    public TaskDto save(String description) {

        Task task = new Task();
        task.setDescription(description);
        task.setStatus(Status.OPEN);
        return super.save(task);
    }

    public String done(Long id) {

        Optional<Task> optionalTask = service.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setStatus(Status.DONE);
            service.save(task);
            return "Successfully done!";
        } else {
            throw new NotFoundException("Task not found by id: " + id);
        }
    }

    public TaskDto update(Long id, String description) {

        Optional<Task> task = service.findById(id);
        if (task.isPresent()) {
            task.get().setDescription(description);
        } else {
            throw new NotFoundException("Task not found by id: " + id);
        }

        return super.save(task.get());
    }
}
