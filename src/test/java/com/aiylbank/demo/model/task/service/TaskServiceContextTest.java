package com.aiylbank.demo.model.task.service;

import com.aiylbank.demo.DemoApplication;
import com.aiylbank.demo.config.TestDatabaseConfig;
import com.aiylbank.demo.model.task.service.dto.TaskDto;
import com.aiylbank.demo.web.common.exception.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {
        DemoApplication.class,
        TestDatabaseConfig.class})
@ActiveProfiles("test")
class TaskServiceContextTest {

    /**
     * Тесты с ипользованием тонтекста программы
     * <br>
     * {@code @ActiveProfile} ипользует отдельный "DataSource" для теста
     * */

    @Autowired
    private TaskService taskService;

    @Test
    void findAll() {
        List<TaskDto> tasks = taskService.findAll();
        Assertions.assertNotNull(tasks);
    }

    @Test
    void deleteByException() {
        Assertions.assertThrows(NotFoundException.class, () -> taskService.delete(Long.MAX_VALUE));
    }

    @Test
    void updateWithException() {
        Assertions.assertThrows(NotFoundException.class, () -> taskService.update(Long.MAX_VALUE, "new some description"));
    }

    @Test
    void save() {
        TaskDto taskDto = taskService.save("saved description");
        Assertions.assertNotNull(taskDto);
    }
}