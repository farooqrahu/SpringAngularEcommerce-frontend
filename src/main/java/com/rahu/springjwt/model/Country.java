package com.rahu.springjwt.model;

import lombok.*;

import javax.persistence.*;

@Getter
@ToString
@Setter
@Entity
@Table(name = "countries")
@AllArgsConstructor
@NoArgsConstructor
public class Country extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "COUNTRY_CODE")
    private String countryCode;

    @Column(name = "COUNTRY_NAME")
    private String countryName;
}
