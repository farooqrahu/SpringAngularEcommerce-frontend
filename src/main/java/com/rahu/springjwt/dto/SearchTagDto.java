package com.rahu.springjwt.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@ToString
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchTagDto {
    private String name;
    private List<PopularSearchTagDto> popularSearchTags = new ArrayList<>();

}

