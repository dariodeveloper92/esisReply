package com.example.esisreply.servicies;

import com.example.esisreply.entities.Customer;
import com.example.esisreply.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Service
@RequestMapping("/customer")
public class CustomerServicies {

    @Autowired
    CustomerRepository customerRepository;

    // TROVA
    @Transactional
    public List<Customer> findAll(){
        //chiamo il repositories
        return customerRepository.findAll();//sto richiamando la CRUD "findAll()" dal Jparepositories
    }

    // SALVA
    @Transactional
    public Customer save(Customer newCustomer) {
        //chiamo il repositories
        return customerRepository.save(newCustomer); //sto richiamando la CRUD "save()" dal Jparepositories
    }

    // TROVA TRAMITE ID
    @Transactional
    public Optional< Customer > findById(Long id) {

        return customerRepository.findById(id);
    }

    // CANCELLA
    @Transactional
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
