package com.example.b02_use_exeptionhandle_springboot.repository;


import com.example.b02_use_exeptionhandle_springboot.model.Province;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceRepository extends CrudRepository<Province, Long> {
}
