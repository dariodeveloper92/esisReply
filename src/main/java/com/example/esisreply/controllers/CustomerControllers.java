package com.example.esisreply.controllers;


import com.example.esisreply.entities.Customer;
import com.example.esisreply.servicies.CustomerServicies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerControllers {

    @Autowired
    CustomerServicies customerServices;

    // TROVA
    @GetMapping//sto dicendo che il metodo corrisponde ad un http Get
    public List<Customer> findAll() {//Array list di tutti gli autori presa dall'entities Authors
        return customerServices.findAll();
    }

    // SAVE
    @PostMapping
    Customer createOrSaveCustomer (@RequestBody Customer newCustomer) {

        return customerServices.save(newCustomer);
    }

    // TROVO TRAMITE ID
    @GetMapping("/{id}")
    Customer getCustomerById(@PathVariable Long id) {

        return customerServices.findById(id).get();
    }

    // CANCELLA
    @DeleteMapping("/{id}")
    void deleteCustomer(@PathVariable Long id) {
        customerServices.deleteCustomer(id);
    }

    // MODIFICA
    @PutMapping
    Customer updateCustomer(@RequestBody Customer newCustomer) {
        Customer customer = new Customer();
        customer.setId(newCustomer.getId());
        customer.setName(newCustomer.getName());
        customer.setSurname(newCustomer.getSurname());
        customer.setAddress(newCustomer.getAddress());
        customer.setFiscalCode(newCustomer.getFiscalCode());
        customer.setBirthDate(newCustomer.getBirthDate());
        return customerServices.save(customer);
    }
}
