package com.rahu.springjwt.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "users_status")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Builder
@Setter()
@Getter()
public class UserStatus extends BaseEntity {
    private String status;

    @JsonBackReference
    @OneToMany(mappedBy = "user_status", orphanRemoval = true, cascade = CascadeType.ALL)
    @Builder.Default
    private List<User> users = new ArrayList<>();

    @Override
    public Long getId() {
        return super.getId();
    }
}
