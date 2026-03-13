Blog Management System
Project Overview
The Blog Management System is a web-based application developed using Java and the Spring MVC framework. The system allows users to create and manage blog posts and retrieve posts based on the user's email address. It demonstrates the implementation of a layered architecture including Controller, Service, DAO, and Entity layers.
The application also includes form validation, custom exception handling, and database persistence using JPA annotations.

Features
	• Create and publish blog posts
	• Retrieve blog posts using the author's email
	• Dynamic theme selection for blog posts
	• Form validation for user input
	• Custom exception handling for invalid operations
	• Display blog reports with multiple posts

Technologies Used
	• Java
	• Spring MVC
	• JSP (Java Server Pages)
	• JPA / Hibernate
	• JDBC
	• SQL Database
	• Apache Tomcat
	• MVC Architecture

Project Architecture
src/com/accenture/lkm
├── bean (Data transfer objects)
├── controller (Handles HTTP requests)
├── dao (Database interaction layer)
├── entity (Database table mapping)
├── exception (Custom exception handling)
├── service (Business logic layer)
├── resources (SQL scripts & configuration)
└── test (Unit test classes)

Database Structure
Table: Blog
Column	Description
blogId	Unique identifier for blog
email	Author email
title	Blog title
themes	Selected theme
content	Blog content

Application Flow
	1. User opens the application homepage
	2. User fills the blog creation form
	3. Controller receives the request
	4. Service layer processes the business logic
	5. DAO layer stores data in the database
	6. User can search and retrieve blog posts using email

Exception Handling
The application handles the following scenarios:
	• Maximum number of blog posts reached
	• No blog posts found for a given email

Author
Mayank Kumar
