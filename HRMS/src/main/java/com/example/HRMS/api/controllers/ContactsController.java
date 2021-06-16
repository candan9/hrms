package com.example.HRMS.api.controllers;

import com.example.HRMS.business.abstracts.ContactService;
import com.example.HRMS.entities.concretes.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contacts")
public class ContactsController {

    private ContactService contactService;

    @Autowired
    public ContactsController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Contact contact){
        return ResponseEntity.ok(this.contactService.add(contact));
    }


    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.contactService.getAll());
    }
}
