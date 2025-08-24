# Leave Management System

A **Java-based Leave Management System** using **JDBC** and **MySQL**.  
This console-based application allows managing employees and their leave requests, demonstrating database connectivity and CRUD operations in Java.

## Features

- Add new employees to the system
- Apply leave for employees
- View all leave requests
- Console-based menu for user interaction

## Technologies Used

- Java
- JDBC (Java Database Connectivity)
- MySQL
- IntelliJ IDEA (IDE)

## Database Setup

1. Create a database in MySQL named `leave_db`:

```sql

2.Create employee table
CREATE DATABASE leave_db;
CREATE TABLE employees (
    emp_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    department VARCHAR(50)
);
3.Create leave_requests table
CREATE TABLE leave_requests (
    leave_id INT PRIMARY KEY AUTO_INCREMENT,
    emp_id INT,
    leave_date DATE,
    reason VARCHAR(100),
    FOREIGN KEY (emp_id) REFERENCES employees(emp_id)
);

USAGE EXAMPLE

1. Add Employee
2. Apply Leave
3. View Leaves
Enter your choice: 1
Enter name: Sriii
Enter department: IT
Employee added!
