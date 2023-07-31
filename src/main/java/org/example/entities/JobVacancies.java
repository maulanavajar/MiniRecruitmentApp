package org.example.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="job_vacancies")
@Data
public class JobVacancies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "job_name")
    private String jobName;

    @Column(name = "description")
    private String description;
}
