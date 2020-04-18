package com.example.demo.rest;

import com.example.demo.persistence.Image;
import com.example.demo.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Validated
public class ImageRestService {

    @Autowired
    ImageService imageService;

    @GetMapping(value = "/v1/images", produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<List<Image>> list() {
        return new ResponseEntity<>(this.imageService.list(), HttpStatus.OK);
    }
    @DeleteMapping(value = "/v1/images", produces = {MediaType.APPLICATION_JSON_VALUE})
    void deleteById(@RequestParam Long id) {
        this.imageService.deleteById(id);
    }
}


