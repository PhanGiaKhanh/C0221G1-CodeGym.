package com.example.productbackend.model.repository;

import com.example.productbackend.model.entity.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface IRoleRepository extends JpaRepository<Role, Integer> {
    @Query(value = "select * from role", nativeQuery = true)
    List<Role> finAllRole();

    @Modifying
    @Query(value = "insert into account_role(account_id,role_id) values (?1,?2)", nativeQuery = true)
    void setDefaultRole(int accountId, Integer roleId);
}
