package com.example.candidaturebachend.repositories;

import com.example.candidaturebachend.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    //Optional<Role> findRoleById(Integer id);
}
