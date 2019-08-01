package com.lambdaschool.starthere.controllers;

import com.lambdaschool.starthere.models.Experience;
import com.lambdaschool.starthere.services.ExperienceService;
import com.lambdaschool.starthere.models.ErrorDetail;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
//import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.HandlerAdapter;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class ExperienceController {

    @Autowired
    private ExperienceService experienceService;

    @ApiOperation(value = "Return all Experiences", response = Experience.class, responseContainer = "List")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "title", dataType = "string", paramType = "query",
                value = "Experiences that you want to show."),
            @ApiImplicitParam(name = "attendees", dataType = "integr", paramType = "query",
                value = "Experiences by number of attendees"),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                value = "Sorting criteria in the format: property(,asc|desc). " +
                        "Default sort order is ascending. " +
                        "Multiple sort criteria are supported.")})

    @GetMapping(value = "/experience")
    public ResponseEntity<?> findAllExperience(Pageable pageable){
        return new ResponseEntity<>(experienceService.findAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "Update a current Experience", response = Experience.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully update experience", response = void.class),
            @ApiResponse(code = 500, message = "Failed to update book", response = ErrorDetail.class)
    })

    @PutMapping(value = "/data/experience/{id}")
    public ResponseEntity<?> updateExperience(@PathVariable long id, @RequestBody Experience experience){
        experienceService.updateExperience(experience, id);
        return new ResponseEntity<>(experience, HttpStatus.OK);
    }

    @ApiOperation(value = "Delete an experience", response = void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully deleted experience", response = void.class),
            @ApiResponse(code = 500, message = "Failed to delete experience", response = ErrorDetail.class)
    })

    @DeleteMapping(value = "/data/experience/{id}")
    public ResponseEntity<?> deleteExperience(@PathVariable long id){
        experienceService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
