# CampusConnect: Student Management System
A Java Servlet + JSP + JDBC + MySQL CRUD web application for an AIP practical project.

## Requirements
- JDK 11 or later
- Maven 3.8+
- Apache Tomcat 9.x (project uses `javax.servlet`)
- MySQL 8.x

## Setup
1. Run `database/campusconnect.sql` in MySQL Workbench or MySQL terminal.
2. Set environment variables before starting Tomcat/IDE:
   - `CAMPUSCONNECT_DB_USER` (defaults to `root`)
   - `CAMPUSCONNECT_DB_PASSWORD` (required; your local MySQL password)
   - `CAMPUSCONNECT_DB_URL` (optional; default `jdbc:mysql://localhost:3306/campusconnect?useSSL=false&serverTimezone=UTC`)
3. Build in this folder: `mvn clean package`
4. Copy `target/CampusConnect.war` to Tomcat 9's `webapps` folder and start Tomcat.
5. Open `http://localhost:8080/CampusConnect/students`.

## Features
- Add, list, edit, and delete student records
- Server-side validation for required fields
- JDBC with `PreparedStatement`
- Duplicate email handling

This is a learning project, not production-ready. It has no authentication/role-based access control. Run it locally and capture real screenshots before describing tests as passed in the report.
