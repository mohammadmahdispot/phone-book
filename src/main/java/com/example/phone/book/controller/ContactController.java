package com.example.phone.book.controller;

import com.example.phone.book.dto.ContactDto;
import com.example.phone.book.service.ContacService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
@RequiredArgsConstructor
public class ContactController {


    @Autowired
    private ContacService contactService;

    @PostMapping
    public ContactDto addContact(@RequestBody ContactDto contactDto) {
        return contactService.addContact(contactDto);
    }

    @PutMapping("/{id}")
    public ContactDto updateContact(@PathVariable Long id, @RequestBody ContactDto contactDto) {
        return contactService.updateContact(id, contactDto);
    }

    @DeleteMapping("/{id}")
    public void deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
    }

    @GetMapping
    public List<ContactDto> findAll() {
        return contactService.findAll();
    }

    @GetMapping("/name/{name}")
    public ContactDto findByName(@PathVariable String name) {
        return contactService.findByName(name);
    }

    @GetMapping("/phone/{phoneNumber}")
    public ContactDto findByPhoneNumber(@PathVariable String phoneNumber) {
        return contactService.findByPhoneNumber(phoneNumber);
    }
}
