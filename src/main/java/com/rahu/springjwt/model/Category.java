package com.rahu.springjwt.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@ToString
@Setter
@Entity
@Table(name = "categories")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category extends BaseEntity{

  @NotBlank
  @Column(unique = true)
  @Size(max = 100)
  private String name;
  private String icon;
}
