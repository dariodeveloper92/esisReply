package com.example.esisreply.servicies;

import com.example.esisreply.entities.Contact;
import com.example.esisreply.entities.Customer;
import com.example.esisreply.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Service
@RequestMapping("/contact")
public class ContactServicies {

    @Autowired
    ContactRepository contactRepository;

    // TROVA
    @Transactional
    public List<Contact> findAll(){
        //chiamo il repositories
        return contactRepository.findAll();//sto richiamando la CRUD "findAll()" dal Jparepositories
    }

    // SALVA
    @Transactional
    public Contact save(Contact newContact) {
        //chiamo il repositories
        return contactRepository.save(newContact); //sto richiamando la CRUD "save()" dal Jparepositories
    }

    // TROVA TRAMITE ID
    @Transactional
    public Optional< Contact > findById(Long id) {

        return contactRepository.findById(id);
    }

    // CANCELLA
    @Transactional
    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }
}
