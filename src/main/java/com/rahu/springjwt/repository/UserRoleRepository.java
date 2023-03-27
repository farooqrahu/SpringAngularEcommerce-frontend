package com.rahu.springjwt.repository;

import com.rahu.springjwt.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}
