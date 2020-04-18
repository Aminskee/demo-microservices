package com.example.demo.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer save(Customer customer);

    @Query(" SELECT c as customer " +
            "  FROM Customer c " +
            " WHERE LOWER(c.firstName) LIKE LOWER(concat(:firstName,'%')) " +
            " OR LOWER(c.lastName) LIKE LOWER(concat(:lastName,'%'))")
    Page<Customer> findCustomerByFirstNameOrLastName(@Param("firstName") String firstName, @Param("lastName") String lastName, Pageable pageRequest);
}
