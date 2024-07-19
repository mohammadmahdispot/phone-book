package com.example.phone.book.repository;

import com.example.phone.book.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    Optional<Contact> findByName(String name);
    Optional<Contact> findByPhoneNumber(String phoneNumber);
}
