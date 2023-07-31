package org.example.controller;

import org.example.entities.Biodata;
import org.example.service.BiodataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("biodata")
public class BiodataApi {
    @Autowired
    BiodataService service;

    @GetMapping("/getall")
    ResponseEntity<Map<String, Object>> getAll(){
        Map<String, Object> response = new HashMap<>();
        try{
            List<Biodata> biodata = service.findAll();
            if (biodata.isEmpty()) {
                response.put("message", "data not found");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }

            response.put("data", biodata);
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
            Biodata biodata = service.findById(id);
            if (biodata==null) {
                response.put("message", "data not found");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }

            response.put("data", biodata);
            response.put("message", "data found");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e) {
            response.put("message", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getByFullname")
    ResponseEntity<Map<String, Object>> getByfullname(@RequestParam(value = "fullname") String fullname){
        Map<String, Object> response = new HashMap<>();
        try{
            List<Biodata> biodata = service.findBiodataByFullname(fullname);
            if (biodata.isEmpty()) {
                response.put("message", "data not found");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }

            response.put("data", biodata);
            response.put("message", "data found");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e) {
            response.put("message", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/save")
    ResponseEntity<Map<String, Object>> save(@RequestBody Biodata biodata) {
        Map<String, Object> response = new HashMap<>();
        try {
            service.save(biodata);

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
