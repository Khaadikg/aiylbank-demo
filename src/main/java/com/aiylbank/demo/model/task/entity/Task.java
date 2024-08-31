package com.aiylbank.demo.model.task.entity;

import com.aiylbank.demo.model.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Entity
@Table(name = "tasks")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Task extends BaseEntity {

    @Column(name = "description")
    String description;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    Status status;
}
