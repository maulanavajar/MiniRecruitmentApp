package org.example.service;

import org.example.entities.Biodata;
import org.example.repositories.BiodataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BiodataService {
    @Autowired
    BiodataRepository biodataRepository;

    public List<Biodata> findAll() {
        return biodataRepository.findAll().stream()
                .sorted(Comparator.comparing(Biodata::getId))
                .collect(Collectors.toList());
    }

    public List<Biodata> findBiodataByFullname(String fullname) {
        return biodataRepository.findByFullname(fullname);
    }

    public Biodata findById(Long id) {
        return biodataRepository.findById(id).orElse(null);
    }

    public void save(Biodata biodata) {
        biodataRepository.save(biodata);
    }

    public void delete(Long id) throws Exception {
        Biodata biodata = findById(id);
        if (biodata==null) throw new Exception("data not found");

        biodataRepository.delete(biodata);
    }
}
