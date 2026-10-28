CREATE DATABASE IF NOT EXISTS campusconnect CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE campusconnect;
CREATE TABLE IF NOT EXISTS students (
 student_id INT AUTO_INCREMENT PRIMARY KEY,
 name VARCHAR(100) NOT NULL,
 email VARCHAR(150) NOT NULL UNIQUE,
 course VARCHAR(100) NOT NULL,
 phone VARCHAR(20),
 created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
INSERT IGNORE INTO students (name,email,course,phone) VALUES
('Aarav Sharma','aarav.example@campusconnect.test','MCA','9000000001'),
('Meera Singh','meera.example@campusconnect.test','BCA','9000000002');
