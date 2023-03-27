/**
 * @author Zeshan Tariq
 * @email zeeshan.tariq@ideatolife.me
 * @create date 2020-05-07 05:44:46
 * @modify date 2020-05-07 05:44:46
 * @desc [description]
 */
package com.rahu.springjwt.repository;

import com.rahu.springjwt.model.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolePermissionRepository extends JpaRepository<RolePermission, Long> {
    List<RolePermission> findAllByRoleId(Long roleId);
}
