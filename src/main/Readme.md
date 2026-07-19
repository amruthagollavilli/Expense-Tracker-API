# Expense Tracker API

A RESTful Expense Tracker backend built using **Java**, **Spring Boot**, **Spring Data JPA**, and **PostgreSQL**. This project allows users to manage their expenses through CRUD operations while maintaining a one-to-many relationship between users and their expenses.

---

# Features

* Create a new user
* View all users
* Create a new expense
* View all expenses
* View an expense by ID
* Update an existing expense
* Delete an expense
* One-to-Many relationship between **User** and **Expense**
* PostgreSQL database integration using Spring Data JPA

---

# Technologies Used

* Java
* Spring Boot
* Spring Data JPA (Hibernate)
* PostgreSQL
* Maven
* Lombok
* Postman

---

# Project Structure


src
├── controller
├── entity
├── repository
├── resources
│   └── application.yaml
└── ExpenseTrackerApiApplication.java




# Database Schema

## User

| Column   | Type   |
| -------- | ------ |
| id       | Long   |
| name     | String |
| email    | String |
| password | String |

## Expense

| Column   | Type        |
| -------- | ----------- |
| id       | Long        |
| title    | String      |
| amount   | BigDecimal  |
| category | String      |
| date     | LocalDate   |
| user_id  | Foreign Key |

Relationship:


User (1)
    │
    │
    └──────────────< Expense (Many)



# API Endpoints

## User APIs

| Method | Endpoint | Description       |
| ------ | -------- | ----------------- |
| POST   | `/users` | Create a new user |
| GET    | `/users` | Get all users     |

## Expense APIs

| Method | Endpoint         | Description                |
| ------ | ---------------- | -------------------------- |
| POST   | `/expenses`      | Create a new expense       |
| GET    | `/expenses`      | Get all expenses           |
| GET    | `/expenses/{id}` | Get expense by ID          |
| PUT    | `/expenses/{id}` | Update an existing expense |
| DELETE | `/expenses/{id}` | Delete an expense          |


# Getting Started

## Clone the repository


git clone https://github.com/amruthagollavilli/Expense-Tracker-API.git


## Configure PostgreSQL

Create a PostgreSQL database named:


expense_tracker


Update the database configuration in `application.yaml`:

yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/expense_tracker
    username: YOUR_USERNAME
    password: YOUR_PASSWORD


## Run the application

Using Maven:


./mvnw spring-boot:run

Or run the `ExpenseTrackerApiApplication` class directly from your IDE.

---

# Testing

The REST APIs were tested using Postman.

---

# Concepts Practiced

* REST API Development
* CRUD Operations
* Spring Boot
* Spring Data JPA
* Hibernate ORM
* PostgreSQL Integration
* One-to-Many and Many-to-One Mapping
* Dependency Injection
* Entity Relationships

---

# Future Improvements

* Service Layer
* Exception Handling
* Input Validation
* JWT Authentication
* Swagger/OpenAPI Documentation
* React Frontend

---

# Author

**Amrutha Gollavilli**

GitHub: https://github.com/amruthagollavilli
