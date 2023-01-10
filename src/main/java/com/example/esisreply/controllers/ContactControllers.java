package com.example.esisreply.controllers;

import com.example.esisreply.entities.Contact;
import com.example.esisreply.servicies.ContactServicies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactControllers {

    @Autowired
    ContactServicies contactServices;

    // TROVA
    @GetMapping//sto dicendo che il metodo corrisponde ad un http Get
    public List<Contact> findAll() {//Array list di tutti gli autori presa dall'entities Authors
        return contactServices.findAll();
    }

    // SAVE
    @PostMapping
    Contact createOrSaveContact (@RequestBody Contact newContact) {

        return contactServices.save(newContact);
    }

    // TROVO TRAMITE ID
    @GetMapping("/{id}")
    Contact getContactById(@PathVariable Long id) {

        return contactServices.findById(id).get();
    }

    // CANCELLA
    @DeleteMapping("/{id}")
    void deleteContact(@PathVariable Long id) {
        contactServices.deleteContact(id);
    }

    // MODIFICA
    @PutMapping("/{id}")
    Contact updateContact(@RequestBody Contact newContact, @PathVariable Long id) {

        return contactServices.findById(id).map(contact -> {
            contact.setCustomerId(newContact.getCustomerId());
            contact.setType(newContact.getType());
            contact.setVal(newContact.getVal());
            contact.setCertified(newContact.getCertified());
            return contactServices.save(contact);
        }).orElseGet(() -> {
            newContact.setId(id);
            return contactServices.save(newContact);
        });
    }
}
