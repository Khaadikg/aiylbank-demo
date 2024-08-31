package com.aiylbank.demo.model.task.service.dto;

import com.aiylbank.demo.model.task.entity.Status;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class TaskDto implements Serializable {
    private Long id;
    private String description;
    private Status status;
}
