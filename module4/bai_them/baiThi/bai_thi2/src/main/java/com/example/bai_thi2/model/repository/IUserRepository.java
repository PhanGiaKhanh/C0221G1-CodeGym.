package com.example.bai_thi2.model.repository;

import com.example.bai_thi2.model.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IUserRepository extends PagingAndSortingRepository<User, Integer> {
}
