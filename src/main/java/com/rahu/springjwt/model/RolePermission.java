package com.rahu.springjwt.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Entity(name = "role_permissions")
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Builder(toBuilder = true)
@Setter()
@Getter()
public class RolePermission extends BaseEntity implements Serializable {

    @OneToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToOne
    @JoinColumn(name = "permission_id")
    private Permission permission;

    private Boolean canView;
    private Boolean canEdit;
}
