# MyDoctorApp - Doctor Appointment Management System

## Overview

MyDoctorApp is a web-based application developed using Java Spring Boot and Hibernate that facilitates the management of doctor appointments. This application streamlines the process of scheduling and managing appointments between patients and doctors, providing a convenient and efficient solution for healthcare professionals and their patients.

## Features

1. **User Authentication:**
   - Secure user authentication for both patients and doctors.
   - Registration and login functionality to access the system.

2. **Appointment Scheduling:**
   - Patients can schedule appointments with their preferred doctors based on the available time slots.
   - Doctors can view and manage their appointment schedules.

3. **Patient Dashboard:**
   - Patients have a personalized dashboard displaying upcoming appointments, past appointments, and relevant information.

4. **Doctor Dashboard:**
   - Doctors have a dedicated dashboard for managing their appointments, viewing patient details, and updating availability.

5. **Notification System:**
   - Automated email or SMS notifications to remind patients and doctors of upcoming appointments.

6. **Profile Management:**
   - Patients and doctors can update their profiles, including contact information and preferences.

7. **Search Functionality:**
   - Patients can search for doctors based on specialization, location, or other relevant criteria.

8. **Admin Panel:**
   - An admin panel for system administrators to manage users, doctors, and system configurations.

## Technologies Used

- **Java Spring Boot:**
  - Backend development framework for building robust and scalable applications.
  
- **Hibernate:**
  - Object-relational mapping (ORM) framework for handling database interactions.

- **Thymeleaf:**
  - Server-side Java template engine for dynamic web page generation.

- **Spring Security:**
  - Provides authentication and authorization features.

- **MySQL:**
  - Database management system for storing and retrieving application data.

- **Spring Data JPA:**
  - Simplifies data access using the Java Persistence API.

## Getting Started
<img src="https://mlsdev.com/images/img/png/devices.png"> 

### Prerequisites

- Java Development Kit (JDK)
- Maven
- MySQL Database

### Installation Steps

1. Clone the repository: `git clone https://github.com/yourusername/MyDoctorApp.git`
2. Configure the database connection in `application.properties`.
3. Build the project: `mvn clean install`
4. Run the application: `java -jar target/mydoctorapp.jar`

Access the application at [http://localhost:8081](http://localhost:8081)

## Contributors

- Anurag Mishra (mishra667@gmail.com)

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

Special thanks to the Java Spring Boot and Hibernate communities for their invaluable contributions.

Feel free to contribute, report issues, or suggest improvements!
