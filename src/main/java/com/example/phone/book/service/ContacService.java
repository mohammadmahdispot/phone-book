package com.example.phone.book.service;

import com.example.phone.book.dto.ContactDto;
import com.example.phone.book.entity.Contact;
import com.example.phone.book.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContacService {
    @Autowired
    private ContactRepository contactRepository;

    private HashMap<Long, Contact> contactCache = new HashMap<>();

    public ContactDto addContact(ContactDto contactDto) {
        Contact contact = new Contact();
        contact.setName(contactDto.getName());
        contact.setPhoneNumber(contactDto.getPhoneNumber());

        contactCache.put(contact.getId(), contact);


        Contact savedContact = contactRepository.save(contact);
        contactDto.setId(savedContact.getId());
        return contactDto;
    }

    public ContactDto updateContact(Long id, ContactDto contactDto) {
        Optional<Contact> contactOpt = contactRepository.findById(id);
        if (contactOpt.isPresent()) {
            Contact contact = contactOpt.get();
            contact.setName(contactDto.getName());
            contact.setPhoneNumber(contactDto.getPhoneNumber());


            contactCache.put(id, contact);


            Contact updatedContact = contactRepository.save(contact);
            contactDto.setId(updatedContact.getId());
            return contactDto;
        }
        return null;
    }

    public void deleteContact(Long id) {

        contactCache.remove(id);


        contactRepository.deleteById(id);
    }

    public List<ContactDto> findAll() {
        return contactRepository.findAll().stream().map(contact -> {
            ContactDto dto = new ContactDto();
            dto.setId(contact.getId());
            dto.setName(contact.getName());
            dto.setPhoneNumber(contact.getPhoneNumber());
            return dto;
        }).collect(Collectors.toList());
    }

    public ContactDto findByName(String name) {

        Optional<Contact> contactOpt = contactCache.values().stream()
                .filter(contact -> contact.getName().equals(name))
                .findFirst();

        if (contactOpt.isPresent()) {
            Contact contact = contactOpt.get();
            ContactDto dto = new ContactDto();
            dto.setId(contact.getId());
            dto.setName(contact.getName());
            dto.setPhoneNumber(contact.getPhoneNumber());
            return dto;
        }


        contactOpt = contactRepository.findByName(name);
        if (contactOpt.isPresent()) {
            Contact contact = contactOpt.get();
            ContactDto dto = new ContactDto();
            dto.setId(contact.getId());
            dto.setName(contact.getName());
            dto.setPhoneNumber(contact.getPhoneNumber());
            return dto;
        }
        return null;
    }

    public ContactDto findByPhoneNumber(String phoneNumber) {

        Optional<Contact> contactOpt = contactCache.values().stream()
                .filter(contact -> contact.getPhoneNumber().equals(phoneNumber))
                .findFirst();

        if (contactOpt.isPresent()) {
            Contact contact = contactOpt.get();
            ContactDto dto = new ContactDto();
            dto.setId(contact.getId());
            dto.setName(contact.getName());
            dto.setPhoneNumber(contact.getPhoneNumber());
            return dto;
        }


        contactOpt = contactRepository.findByPhoneNumber(phoneNumber);
        if (contactOpt.isPresent()) {
            Contact contact = contactOpt.get();
            ContactDto dto = new ContactDto();
            dto.setId(contact.getId());
            dto.setName(contact.getName());
            dto.setPhoneNumber(contact.getPhoneNumber());
            return dto;
        }
        return null;
    }
}
