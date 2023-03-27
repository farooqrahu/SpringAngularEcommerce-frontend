package com.rahu.springjwt.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@ToString
@Setter
@Getter
@Entity
@Table(name = "companies")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Company extends BaseEntity {
    @NotBlank
    @Column(unique = true)
    @Size(max = 20)
    private String name;
}

