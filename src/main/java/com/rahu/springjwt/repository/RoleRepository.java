/**
 * @desc [description]
 */
package com.rahu.springjwt.repository;

import com.rahu.springjwt.model.ERole;
import com.rahu.springjwt.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
  Role findBySlug(String slug);
}
