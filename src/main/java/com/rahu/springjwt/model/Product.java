package com.rahu.springjwt.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Setter
@Getter
@Entity
@Table(name = "products")
public class Product extends BaseEntity {
    @NotBlank
    @Size(max = 20)
    private String name;
    @Nullable
    private String description = "";
    private Double price;
    @Nullable
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    private Category category;
    @Nullable
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Company company;

    private String make;
    private String year;
    private String model;
    private String condition;
    private String titleImagePath;

}
