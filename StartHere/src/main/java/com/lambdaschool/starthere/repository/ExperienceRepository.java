package com.lambdaschool.starthere.repository;

import com.lambdaschool.starthere.models.Experience;
import org.springframework.data.repository.CrudRepository;

public interface ExperienceRepository extends CrudRepository<Experience, Long>{
    Experience findByTitle(String title);
}