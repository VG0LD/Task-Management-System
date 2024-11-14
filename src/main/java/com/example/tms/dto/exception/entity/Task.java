package com.example.tms.dto.exception.entity;

import jakarta.persistence.*;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String status; // "Pending", "In Progress", "Completed"
    private String priority; // "High", "Medium", "Low"
    @ManyToOne
    private User author;
    @ManyToOne
    private User assignee;
}

