package com.rahu.springjwt.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@ToString
@Setter
@Getter
@Entity
@Table(name = "pupular_search_tages")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PopularSearchTag extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "search_tag_id")
    private SearchTag searchTag;
    Long count;

}

