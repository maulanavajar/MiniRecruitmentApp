package org.example.service;

import org.example.entities.Biodata;
import org.example.entities.JobVacancies;
import org.example.repositories.JobVacanciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobVacanciesService {
    @Autowired
    JobVacanciesRepository jobVacanciesRepository;

    public List<JobVacancies> findAll() {
        return jobVacanciesRepository.findAll().stream()
                .sorted(Comparator.comparing(JobVacancies::getId))
                .collect(Collectors.toList());
    }

    public List<JobVacancies> findByJobName(String jobName) {
        return jobVacanciesRepository.findAll().stream()
                .filter(p-> p.getJobName().contains(jobName))
                .sorted(Comparator.comparing(JobVacancies::getId))
                .collect(Collectors.toList());
    }

    public JobVacancies findById(Long id) {
        return jobVacanciesRepository.findById(id).orElse(null);
    }

    public void save(JobVacancies jobVacancies) {
        jobVacanciesRepository.save(jobVacancies);
    }

    public void delete(Long id) throws Exception {
        JobVacancies vacancies = findById(id);
        if (vacancies==null) throw new Exception("data not found");

        jobVacanciesRepository.delete(vacancies);
    }


}
