package com.example.demo.adapter.imageservice;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(value = "service",
        url = "http://localhost:4040/api/v1/images")
public interface ImageServiceClient {

    @GetMapping(value = "")
    List<Image> getImages();

    @DeleteMapping(value = "")
    Optional deleteImageById(@RequestParam Long id);
}
