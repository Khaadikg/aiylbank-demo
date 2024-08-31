package com.aiylbank.demo.web;

import com.aiylbank.demo.model.task.service.TaskService;
import com.aiylbank.demo.web.common.BaseEntityController;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/service/tasks")
public class TaskController extends BaseEntityController {

    private final TaskService taskService;

    @PostMapping(value = "/find-by-id/{id}")
    public ResponseEntity<?> updateFromBi(@PathVariable @Min(value = 0, message = "id must not be less then 0 !") Long id) {
        return ResponseEntity.ok(taskService.findById(id));
    }

    @GetMapping(value = "/find-all")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(taskService.findAll());
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable @Min(value = 0, message = "id must not be less then 0 !") Long id) {
        return ResponseEntity.ok(taskService.delete(id));
    }

    @PostMapping(value = "/update/{id}")
    public ResponseEntity<?> update(@PathVariable @Min(value = 0, message = "id must not be less then 0 !") Long id,
                                    @RequestParam @NotBlank( message = "description must not be null or empty!") String description) {
        return ResponseEntity.ok(taskService.update(id, description));
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> save(@RequestParam @NotBlank(message = "description must not be null or empty!") String description) {
        return ResponseEntity.ok(taskService.save(description));
    }

    @PostMapping(value = "/do-done/{id}")
    public ResponseEntity<?> done(@PathVariable @Min(value = 0, message = "id must not be less then 0 !") Long id) {
        return ResponseEntity.ok(taskService.done(id));
    }
}
