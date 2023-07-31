package org.example.controller;

import org.example.entities.Biodata;
import org.example.entities.JobVacancies;
import org.example.service.JobVacanciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("jobvacancies")
public class JobVacanciesApi {
    @Autowired
    JobVacanciesService service;

    @GetMapping("/getall")
    ResponseEntity<Map<String, Object>> getAll(){
        Map<String, Object> response = new HashMap<>();
        try{
            List<JobVacancies> vacancies = service.findAll();
            if (vacancies.isEmpty()) {
                response.put("message", "data not found");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }

            response.put("data", vacancies);
            response.put("message", "data found");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e) {
            response.put("message", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getById")
    ResponseEntity<Map<String, Object>> getById(@RequestParam(value = "id") Long id){
        Map<String, Object> response = new HashMap<>();
        try{
            JobVacancies vacancies = service.findById(id);
            if (vacancies==null) {
                response.put("message", "data not found");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }

            response.put("data", vacancies);
            response.put("message", "data found");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e) {
            response.put("message", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getByJobName")
    ResponseEntity<Map<String, Object>> getByfullname(@RequestParam(value = "jobName") String jobName){
        Map<String, Object> response = new HashMap<>();
        try{
            List<JobVacancies> vacancies = service.findByJobName(jobName);
            if (vacancies.isEmpty()) {
                response.put("message", "data not found");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }

            response.put("data", vacancies);
            response.put("message", "data found");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e) {
            response.put("message", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/save")
    ResponseEntity<Map<String, Object>> save(@RequestBody JobVacancies jobVacancies) {
        Map<String, Object> response = new HashMap<>();
        try {
            service.save(jobVacancies);

            response.put("message", "data has been saved");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("message", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete")
    ResponseEntity<Map<String, Object>> delete(@RequestParam(value = "id") Long id){
        Map<String, Object> response = new HashMap<>();
        try{
            service.delete(id);
            response.put("message", "delete success");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e) {
            response.put("message", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
