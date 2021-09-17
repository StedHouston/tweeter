package com.stedHouston.tweeter.repository;

import com.stedHouston.tweeter.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
