package com.lambdaschool.starthere.controllers;

import com.lambdaschool.starthere.models.Experience;
import com.lambdaschool.starthere.services.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/experiences")
public class ExperienceController {
    @Autowired
    private ExperienceService experienceService;

    @GetMapping(value = "/experiences",
                produces = {"application/json"})
    public ResponseEntity<?> listAllExperiences() {
        List<Experience> myExperiences = experienceService.findAll();
        return new ResponseEntity<>(myExperiences, HttpStatus.OK);
    }

    @GetMapping(value = "/experience/{experienceId}",
                produces = {"application/json"})
    public ResponseEntity<?> getExperienceById(
            @PathVariable
                Long experienceId) {
        Experience e = experienceService.findExperienceById(experienceId);
        return new ResponseEntity<>(e, HttpStatus.OK);
    }

    @GetMapping(value = "experience/title/{title{",
                produces = {"application/json"})
    public ResponseEntity<?> getExperienceByTitle (
            @PathVariable
                String title) {
        Experience e = experienceService.findExperienceByTitle(title);
        return new ResponseEntity<>(e, HttpStatus.OK);
    }

    @PostMapping(value = "/experience",
                consumes = {"application/json"},
                produces = {"application/json"})
    public ResponseEntity<?> addNewExperience(@Valid
                                              @RequestBody
                                              Experience newExperience) throws URISyntaxException {
        newExperience = experienceService.save (newExperience);

        // set the location header for the newly created experience
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newExperienceURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{experienceid}").buildAndExpand(newExperience.getExperienceid()).toUri();
        responseHeaders.setLocation(newExperienceURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @PutMapping(value = "/experience/{experienceid}")
    public ResponseEntity<?> updateExperience (
            @RequestBody
                Experience updateExperience,
            @PathVariable
                long experienceid) {
        experienceService.update(updateExperience, experienceid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/experience/{experienceid}")
    public ResponseEntity<?> deleteExperienceById(
            @PathVariable
                long experienceid) {
        experienceService.delete(experienceid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
