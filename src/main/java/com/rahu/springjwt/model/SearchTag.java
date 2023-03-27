package com.rahu.springjwt.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "search_tages")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchTag extends BaseEntity {
    @NotBlank
    @Column(unique = true)
    @Size(max = 20)
    private String name;

    @JsonBackReference
    @OneToMany(mappedBy = "searchTag", orphanRemoval = true, cascade = CascadeType.ALL)
    @Builder.Default
    private List<PopularSearchTag> popularSearchTags = new ArrayList<>();

}

