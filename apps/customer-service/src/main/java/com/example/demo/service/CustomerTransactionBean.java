package com.example.demo.service;

import com.example.demo.persistence.Customer;
import com.example.demo.persistence.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.persistence.EntityManager;

@Component
public class CustomerTransactionBean {

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Autowired
    private EntityManager entityManager;


    public void deleteCustomers(Long id) {

        TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);

        //new transaction boundary
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {

            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                try {
                    System.out.println("id generated: " + id);
                } catch (Exception e) {
                    logException(e);
                    transactionManager.rollback(status);
                }
            }
        });

        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                try {
                    Customer customer = entityManager.find(Customer.class, id);
                    entityManager.remove(customer);
                    System.out.println("customer removed: " + id);
                } catch (Exception e) {
                    logException(e);
                    transactionManager.rollback(status);
                }
            }
        });
    }

    private static void logException(Exception e) {
        System.out.println("-- exception message --");
        System.err.println(e.getMessage());
        System.out.println("---------");
    }
}
