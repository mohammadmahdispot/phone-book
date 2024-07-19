package com.example.phone.book.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactDto {

    private Long id;
    private String phoneNumber;
    private String name;
    private String description;

}
