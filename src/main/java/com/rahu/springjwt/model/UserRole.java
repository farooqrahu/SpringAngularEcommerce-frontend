package com.rahu.springjwt.model;

import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "user_roles")
@Where(clause = "deleted_at is null")
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Accessors(chain = true)
@Builder(toBuilder = true)
@Setter
@Getter
public class UserRole extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "role_permission_id")
    private RolePermission rolePermission;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
