# CLI Student Management System 🎓

A simple **Command Line Interface (CLI)** based Student Management System built with **Java** and **MySQL** using **JDBC**. This project demonstrates core CRUD operations and is a great beginner-friendly example of connecting Java applications to databases.

## 🔧 Features

- ➕ Add new student
- 📋 View all students
- 🔍 Search student by ID
- ✏️ Update student details
- ❌ Delete student
- 💾 Database integration using JDBC
- 📦 Maven project structure

## 📂 Project Structure

StudentManagementSystem/ ├── src/ │ └── main/ │ └── java/ │ └── lk/ │ └── test/ │ └── mihi/ │ ├── Main.java │ ├── Student.java │ ├── StudentService.java │ └── DBConnection.java ├── pom.xml └── README.md


## 🧰 Technologies Used

- Java 17+
- MySQL
- JDBC
- Maven
- IntelliJ IDEA

## 🛠️ Setup Instructions

1. **Clone the repository**

```bash
git clone https://github.com/ChamodLa/CLI-Student-management-System-.git
cd CLI-Student-management-System-
```

Set up MySQL Database

```bash
CREATE DATABASE student_db;

USE student_db;

CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INT
);
```

Configure DB connection in DBConnection.java
```bash
private static final String URL = "jdbc:mysql://localhost:3306/student_db";
private static final String USER = "your_mysql_user";
private static final String PASSWORD = "your_mysql_password";
```
Build and run the project

Using IntelliJ IDEA or:

```bash

mvn compile
mvn exec:java -Dexec.mainClass="com.saegis.Main"
```

✍️ Author
Chamod Lakshan

📃 License
This project is open-source and available under the MIT License.
