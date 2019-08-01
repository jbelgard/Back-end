package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.models.Experience;

import java.util.List;

public interface ExperienceService {
    List<Experience> findAll();

    Experience findExperienceById(long id);

    Experience findExperienceByTitle(String title);

    void delete(long id);

    Experience updateExperience(Experience experience, long id);

    Experience save(Experience experience);

    Experience update(Experience experience, long id);
}
