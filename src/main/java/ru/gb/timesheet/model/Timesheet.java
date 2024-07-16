package ru.gb.timesheet.model;

import lombok.Data;

import java.time.LocalDate;

// Аннотация Data от lombok добавляет геттеры и сеттеры
@Data
public class Timesheet {

    private Long id;
    private Long projectId;
    private int minutes;
    private LocalDate createdAt;

}
