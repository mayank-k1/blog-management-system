# Blog Management System

## Project Overview
The Blog Management System is a web-based application developed using Java and the Spring MVC framework. The application allows users to create blog posts and retrieve posts based on the author's email. The project demonstrates the implementation of layered MVC architecture including Controller, Service, DAO, and Entity layers.

The application also includes form validation, exception handling, and database persistence using JPA.

---

## Features
- Create and publish blog posts  
- Retrieve blog posts using the author's email  
- Dynamic theme selection for blog posts  
- Form validation for user input  
- Custom exception handling  
- Display blog reports with multiple posts  

---

## Technologies Used
- Java  
- Spring MVC  
- JSP (Java Server Pages)  
- JPA / Hibernate  
- JDBC  
- SQL Database  
- Apache Tomcat  
- MVC Architecture  

---

## Project Architecture

src/com/accenture/lkm
├── bean
├── controller
├── dao
├── entity
├── exception
├── service
├── resources
└── test


---

## Database Structure

### Table: Blog

| Column | Description |
|------|-------------|
| blogId | Unique blog identifier |
| email | Author email |
| title | Blog title |
| themes | Blog theme |
| content | Blog content |

---

## Application Flow
1. User opens the application homepage  
2. User fills the blog creation form  
3. Controller receives the request  
4. Service layer processes business logic  
5. DAO layer stores data in the database  
6. Users can retrieve blog posts using email  

---

## Exception Handling
The system handles the following cases:
- Maximum allowed blog entries reached  
- No blog posts found for the given email  

---

## Author
Mayank Kumar  
