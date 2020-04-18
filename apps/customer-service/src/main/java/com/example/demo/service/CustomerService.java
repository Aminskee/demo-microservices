package com.example.demo.service;

import com.example.demo.adapter.imageservice.Image;
import com.example.demo.adapter.imageservice.ImageServiceClient;
import com.example.demo.exception.DeleteException;
import com.example.demo.persistence.Customer;
import com.example.demo.persistence.CustomerRepository;
import feign.RetryableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public static final String SORTED_BY_FIRSTNAME = "firstName";

    @Autowired
    ImageServiceClient imageServiceClient;

    public List<Customer> list(){
        return customerRepository.findAll(Sort.by(SORTED_BY_FIRSTNAME));
    }

    public List<Image> imageList(){
        return imageServiceClient.getImages();
    }

    public Customer create(Customer customer) {
         return customerRepository.save(customer);
    }

    public Page<Customer> findByFirstNameOrByLastName(String searchText, Pageable pageRequest) {
        Pageable sortedByFirstName = PageRequest.of(pageRequest.getPageNumber(), pageRequest.getPageSize(), Sort.by(SORTED_BY_FIRSTNAME));
        return customerRepository.findCustomerByFirstNameOrLastName(searchText, searchText, sortedByFirstName);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Customer customer){
        customerRepository.deleteById(customer.getId());
        imageServiceClient.deleteImageById(customer.getId());
    }
}
