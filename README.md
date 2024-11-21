# Pharma Assist Project

Pharma Assist is a comprehensive web application designed to manage and streamline pharmaceutical operations. It provides efficient handling of medicines, pharmacies, patient records, transactions, and billing processes. The project is built using **Spring Boot**, implementing a robust backend architecture with a focus on modularity and scalability.

---

## **Project Features**

1. **Admin Module**
   - User authentication with **Spring Security**.
   - CRUD operations for managing pharmacy users.
   - Role-based access control (Admin & Staff).

2. **Pharmacy Module**
   - Manage pharmacy details including contact and location information.
   - Integration with Admin for pharmacy assignment.

3. **Medicine Module**
   - Add, update, and delete medicine records.
   - Track inventory and stock levels.

4. **Patient Module**
   - Register and manage patient details.
   - Link patient records with transaction history.

5. **Transaction Module**
   - Record purchase and billing transactions.
   - Handle invoices and payment processing.

6. **Billing and Fine**
   - Generate detailed bills for patients.
   - Manage overdue fines and payment status.

---

## **Tech Stack**

### **Backend**
- **Java 8**
- **Spring Boot** (Core Framework)
- **Spring Data JPA** (Database Access)
- **Spring Security** (Authentication & Authorization)

### **Database**
- **MySQL** (Relational Database)
- **H2 Database** (For testing)

### **Build Tool**
- **Maven**

### **Other Tools**
- **Postman** (API Testing)
- **Git** (Version Control)
- **GitHub** (Code Repository)

---

## **Project Structure**

```plaintext
Pharma-Assist/
├── src/main/java/com/pharmaassist
│   ├── controller/          # REST Controllers for API endpoints
│   ├── service/             # Business Logic Layer
│   ├── repository/          # JPA Repository Interfaces
│   ├── model/               # Entity Classes
│   ├── config/              # Security and Application Configurations
├── src/main/resources/
│   ├── application.properties # Configuration file for DB, Security, etc.
├── pom.xml                  # Maven dependencies
└── README.md                # Project documentation
