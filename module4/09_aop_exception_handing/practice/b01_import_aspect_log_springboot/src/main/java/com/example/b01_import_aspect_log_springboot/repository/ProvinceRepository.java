package com.example.b01_import_aspect_log_springboot.repository;


import com.example.b01_import_aspect_log_springboot.model.Province;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceRepository extends CrudRepository<Province, Long> {
}
