package com.aiylbank.demo.database.task;

import com.aiylbank.demo.database.common.BaseStorageService;
import com.aiylbank.demo.model.task.dao.TaskStorageService;
import com.aiylbank.demo.model.task.entity.Task;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Getter
@Component
@RequiredArgsConstructor
public class TaskStorageServiceImpl extends BaseStorageService<Task, Long, TaskRepository> implements TaskStorageService {

    private final TaskRepository repository;
}
