package org.example.repositories;

import org.example.entities.JobVacancies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobVacanciesRepository extends JpaRepository<JobVacancies, Long> {
}
