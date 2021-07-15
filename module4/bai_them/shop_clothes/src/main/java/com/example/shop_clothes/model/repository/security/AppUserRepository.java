package com.example.shop_clothes.model.repository.security;


import com.example.shop_clothes.model.entity.user.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser,Long> {
    AppUser findByUserName(String userName);

}
