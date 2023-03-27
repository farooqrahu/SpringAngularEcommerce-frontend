package com.rahu.springjwt.repository;

import com.rahu.springjwt.model.SearchTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by farooq.ahmed
 */

@Repository
public interface SearchTagRepository extends JpaRepository<SearchTag, Long> {

    SearchTag findByName(String name);
}
