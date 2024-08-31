package com.aiylbank.demo.model.task.service;

import com.aiylbank.demo.model.task.dao.TaskStorageService;
import com.aiylbank.demo.model.task.entity.Task;
import com.aiylbank.demo.model.task.service.dto.TaskDto;
import com.aiylbank.demo.web.common.exception.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class TaskServiceMockitoTest {

    /**
     * Тесты с ипользованием библиотеки {@code Mockito}
     * <br>
     * {@code Mockito} — фреймворк для работы с заглушками
     * */

    @InjectMocks
    private TaskService taskService;

    @Mock
    private TaskStorageService taskStorageService;

    @Test
    void findAll() {
        Mockito.when(taskStorageService.findAll()).thenReturn(List.of(getTask()));
        List<TaskDto> tasks = taskService.findAll();
        Assertions.assertNotNull(tasks);
    }

    @Test
    void findById() {
        Mockito.when(taskStorageService.findById(Mockito.anyLong())).thenReturn(Optional.of(getTask()));
        TaskDto task = taskService.findById(1L);
        Assertions.assertNotNull(task);
    }

    @Test
    void delete() {
        Optional<Task> optionalTask = Optional.of(getTask());
        Mockito.when(taskStorageService.findById(Mockito.anyLong())).thenReturn(optionalTask);
        String responseString = taskService.delete(1L);
        Assertions.assertNotNull(responseString);
    }

    @Test
    void deleteByException() {
        Mockito.when(taskStorageService.findById(Mockito.anyLong())).thenReturn(Optional.empty());
        Assertions.assertThrows(NotFoundException.class, () -> taskService.delete(Long.MAX_VALUE));
    }


    @Test
    void update() {
        Optional<Task> optionalTask = Optional.of(getTask());
        Mockito.when(taskStorageService.findById(Mockito.anyLong())).thenReturn(optionalTask);
        Mockito.when(taskStorageService.save(Mockito.any())).thenReturn(getTask());
        Assertions.assertDoesNotThrow(() -> taskService.update(1L, "new some description"));
    }

    @Test
    void updateWithException() {
        Mockito.when(taskStorageService.findById(Mockito.anyLong())).thenReturn(Optional.empty());
        Assertions.assertThrows(NotFoundException.class, () -> taskService.update(Long.MAX_VALUE, "new some description"));
    }

    @Test
    void save() {
        Mockito.when(taskStorageService.save(Mockito.any())).thenReturn(getTask());
        TaskDto taskDto = taskService.save("saved description");
        Assertions.assertNotNull(taskDto);
    }

    private Task getTask() {

        Task task = new Task();
        task.setDescription("description");

        return task;
    }
}