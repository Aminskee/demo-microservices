package com.example.demo.rest;

import com.example.demo.adapter.imageservice.Image;
import com.example.demo.exception.DeleteException;
import com.example.demo.persistence.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Validated
public class CustomerRestService {

    @Autowired
    CustomerService customerService;

    @GetMapping(value = "/v1/customers", produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<List<Customer>> list() {
        return new ResponseEntity<>(this.customerService.list(), HttpStatus.OK);
    }

    @GetMapping(value = "/v1/customers/getImages", produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<List<Image>> listImage() {
        return new ResponseEntity<>(this.customerService.imageList(), HttpStatus.OK);
    }

    @PostMapping(value = "/v1/customers", produces = {
            MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Customer> create(@RequestBody Customer customer) {
        return new ResponseEntity<>(this.customerService.create(customer), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/v1/customers", produces = {
            MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void deleteById(@RequestBody Customer customer) throws Throwable {
        this.customerService.deleteById(customer);
    }

    @GetMapping(value = "/v1/customers/search", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Page<Customer>> findByFirstNameOrLastName(
            @RequestParam @NotBlank(message = "The search text should not be blank")
            @Pattern(regexp = "^[A-Za-z]+$", message = "The search text must contain only letters")
            @Size(min = 2, max = 10, message = "The search text size must be between 2 and 25")
                    String searchText, Pageable pageRequest) {
        return new ResponseEntity<>(this.customerService.findByFirstNameOrByLastName(searchText, pageRequest), HttpStatus.OK);
    }

}


