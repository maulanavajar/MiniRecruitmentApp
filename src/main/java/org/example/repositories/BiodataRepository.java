package org.example.repositories;

import org.example.entities.Biodata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BiodataRepository extends JpaRepository<Biodata, Long> {
    @Query(value = "SELECT * FROM biodata WHERE fullname ilike %?1% order by id asc", nativeQuery = true)
    List<Biodata> findByFullname(String fullname);
}
