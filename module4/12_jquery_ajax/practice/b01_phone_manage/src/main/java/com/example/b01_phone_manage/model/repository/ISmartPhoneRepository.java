package com.example.b01_phone_manage.model.repository;

import com.example.b01_phone_manage.model.entity.SmartPhone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISmartPhoneRepository extends CrudRepository<SmartPhone, Long> {
}
