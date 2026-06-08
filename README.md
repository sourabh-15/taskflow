#  TaskFlow API – Task Management System (Spring Boot)

A **RESTful backend application** built using **Spring Boot** for managing tasks with features like **CRUD operations**, **filtering**, **validation**, and **global exception handling**.  
This project demonstrates strong understanding of **Java backend development**, **REST API design**, and **database integration** using **Spring Data JPA and Hibernate**.

---

##  Key Features

*  RESTful API development using Spring Boot
*  Full CRUD operations (Create, Read, Update, Delete)
*  Filter tasks by status (**PENDING, IN_PROGRESS, COMPLETED**)
*   Input validation using **Jakarta Validation (`@NotBlank`)**
*  Global exception handling using `@RestControllerAdvice`
*  Layered architecture (**Controller → Service → Repository**)
*  Database integration with **Spring Data JPA & Hibernate**
*  Interactive API documentation using **Swagger (OpenAPI)**
*  API testing using **Postman Collection**

---

##  Tech Stack

| Category   | Technology                  |
| ---------- | --------------------------- |
| Language   | Java 17                     |
| Framework  | Spring Boot                 |
| ORM        | Spring Data JPA, Hibernate  |
| Database   | MySQL 8.0+                  |
| Build Tool | Maven                       |
| API Docs   | Swagger (springdoc-openapi) |
| Testing    | Postman                     |

---

##  Quick Start

### 🔹 Prerequisites

* Java 17+
* MySQL 8.0+
* Maven 3.8+

---

### 🔹 1. Database Setup

```sql
CREATE DATABASE taskflow;
```

Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/taskflow
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

---

### 🔹 2. Run Application

```bash
git clone https://github.com/gauravsingh/taskflow.git
cd taskflow
mvn spring-boot:run
```

---

##  API Base URL

```
http://localhost:8080/todos
```

---

##  API Documentation

🔗 Swagger UI:
http://localhost:8080/swagger-ui/index.html

* Explore all endpoints
* Execute API requests directly
* View request/response structure

---

##  Postman Collection

Import the collection from:

```
postman/TaskFlow-API.postman_collection.json
```

---

##  API Endpoints

| Method | Endpoint               | Description            |
| ------ | ---------------------- | ---------------------- |
| POST   | /todos                 | Create task            |
| GET    | /todos                 | Get all tasks          |
| GET    | /todos/{id}            | Get task by ID         |
| PUT    | /todos/{id}            | Update task            |
| DELETE | /todos/{id}            | Delete task            |
| GET    | /todos/status/{status} | Filter tasks by status |

---

##  Sample Request

```json
{
  "title": "Complete TaskFlow README",
  "content": "Polish documentation",
  "status": "IN_PROGRESS",
  "dueDate": "30-04-2026 23:59:59"
}
```

---

##  Author

**Gaurav Singh**
Java Backend Developer | Pune, Maharashtra

* GitHub: https://github.com/gv-arc
* LinkedIn: https://www.linkedin.com/in/gauravsingh720

---

##  Key Skills Demonstrated

- Java (Core Java, OOPs, Collections)
- Spring Boot (RESTful Web Services)
- Spring Data JPA & Hibernate (ORM)
- MySQL Database Integration
- REST API Design & Development
- CRUD Operations & Business Logic Implementation
- Input Validation (Jakarta Validation - @NotBlank)
- Global Exception Handling (@RestControllerAdvice)
- API Documentation (Swagger / OpenAPI)
- API Testing (Postman)
- Maven (Build & Dependency Management)
- Layered Architecture (Controller → Service → Repository)
- JSON Processing (Jackson)
- Logging (SLF4J)
