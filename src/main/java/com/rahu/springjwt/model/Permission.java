package com.rahu.springjwt.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity(name = "permissions")
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Builder(toBuilder = true)
@Setter()
@Getter()
public class Permission extends BaseEntity implements Serializable {

    private String description;
    private String name;
    private String slug;
}
