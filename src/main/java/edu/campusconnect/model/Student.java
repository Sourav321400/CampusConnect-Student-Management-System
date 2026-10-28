package edu.campusconnect.model;
public class Student {
 private int studentId; private String name,email,course,phone;
 public Student() {}
 public Student(int id,String name,String email,String course,String phone){this.studentId=id;this.name=name;this.email=email;this.course=course;this.phone=phone;}
 public int getStudentId(){return studentId;} public void setStudentId(int v){studentId=v;}
 public String getName(){return name;} public void setName(String v){name=v;}
 public String getEmail(){return email;} public void setEmail(String v){email=v;}
 public String getCourse(){return course;} public void setCourse(String v){course=v;}
 public String getPhone(){return phone;} public void setPhone(String v){phone=v;}
}
