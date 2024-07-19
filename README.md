# Phonebook Application

This is a simple Phonebook application built with Java, Spring Boot, and PostgreSQL. The application allows users to manage their contacts by adding, updating, deleting, and searching contacts by name or phone number.

## Features

- Add a new contact
- Update an existing contact
- Delete a contact
- Find contacts by name
- Find contacts by phone number
- In-memory cache using HashMap for improved performance
- RESTful API

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Lombok

## Getting Started

### Prerequisites

- Java 8 or higher
- Maven
- PostgreSQL

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/phonebook.git
   cd phonebook

   spring.datasource.url=jdbc:postgresql://localhost:5432/phonebook
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true


mvn clean install
mvn spring-boot:run


POST /contacts
{
    "name": "John Doe",
    "phoneNumber": "123-456-7890"
}


{
    "id": 1,
    "name": "John Doe",
    "phoneNumber": "123-456-7890"
}

