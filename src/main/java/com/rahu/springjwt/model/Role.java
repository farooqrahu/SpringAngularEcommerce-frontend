package com.rahu.springjwt.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role extends BaseEntity{

  @Enumerated(EnumType.STRING)
  @Column(length = 20)
  private ERole name;
private String slug;

  public Role(ERole roleAdmin) {
    this.name=roleAdmin;
  }


  @Override
  public String toString() {
    return "{" + " id='" + getId() + "'" + ", name='" + getName() + "'" + "}";
  }
}
