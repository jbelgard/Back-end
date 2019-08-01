package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.models.Experience;
import com.lambdaschool.starthere.repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "experienceService")
public class ExperienceServiceImpl implements ExperienceService {

    @Autowired
    private ExperienceRepository exprepos;

    @Override
    public List<Experience> findAll(){
        List<Experience> list = new ArrayList<>();
        exprepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Experience findExperienceById(long id) throws EntityNotFoundException {
        return exprepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
    }

    @Override
    public Experience findExperienceByTitle(String title) throws EntityNotFoundException {
        Experience experience = exprepos.findByTitle(title);

        if (experience == null) {
            throw new EntityNotFoundException("Experience " + title + " not found!");
        }
        return experience;
    }

    @Override
    public void delete(long id) {
        if (exprepos.findById(id).isPresent()) {
            exprepos.deleteById(id);
        }
        else {
            throw new EntityNotFoundException(Long.toString(id));
        }
    }

    @Transactional
    @Override
    public Experience save(Experience experience) {
        Experience newExperience = new Experience();

        newExperience.setTitle(experience.getTitle());
        newExperience.setBody(experience.getBody());
        newExperience.setSlots(experience.getSlots());
        newExperience.setCost(experience.getCost());

        return exprepos.save(newExperience);
    }

    @Override
    public Experience update(Experience experience, long id) {
        return null;
    }

    @Transactional
    @Override
    public Experience updateExperience(Experience experience, long id) {
        Experience currentExperience = exprepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));

        if (experience.getTitle() != null) {
            currentExperience.setTitle(experience.getTitle());
        }

        if (experience.getBody() != null) {
            currentExperience.setBody(experience.getBody());
        }

        if (experience.getSlots() != 0) {
            currentExperience.setSlots(experience.getSlots());
        }

        if (experience.getCost() != 0) {
            currentExperience.setCost(experience.getCost());
        }

        return exprepos.save(currentExperience);
    }
}
