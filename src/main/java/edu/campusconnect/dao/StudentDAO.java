package edu.campusconnect.dao;
import edu.campusconnect.model.Student;
import edu.campusconnect.util.DBUtil;
import java.sql.*; import java.util.*;
public class StudentDAO {
 public List<Student> findAll() throws SQLException {
  String sql="SELECT student_id,name,email,course,phone FROM students ORDER BY student_id DESC"; List<Student> out=new ArrayList<>();
  try(Connection c=DBUtil.getConnection();PreparedStatement p=c.prepareStatement(sql);ResultSet r=p.executeQuery()){while(r.next())out.add(map(r));} return out;
 }
 public Student findById(int id) throws SQLException {
  try(Connection c=DBUtil.getConnection();PreparedStatement p=c.prepareStatement("SELECT student_id,name,email,course,phone FROM students WHERE student_id=?")){p.setInt(1,id);try(ResultSet r=p.executeQuery()){return r.next()?map(r):null;}}
 }
 public void insert(Student s) throws SQLException {
  try(Connection c=DBUtil.getConnection();PreparedStatement p=c.prepareStatement("INSERT INTO students(name,email,course,phone) VALUES(?,?,?,?)")){p.setString(1,s.getName());p.setString(2,s.getEmail());p.setString(3,s.getCourse());p.setString(4,s.getPhone());p.executeUpdate();}
 }
 public boolean update(Student s) throws SQLException {
  try(Connection c=DBUtil.getConnection();PreparedStatement p=c.prepareStatement("UPDATE students SET name=?,email=?,course=?,phone=? WHERE student_id=?")){p.setString(1,s.getName());p.setString(2,s.getEmail());p.setString(3,s.getCourse());p.setString(4,s.getPhone());p.setInt(5,s.getStudentId());return p.executeUpdate()==1;}
 }
 public boolean delete(int id) throws SQLException {
  try(Connection c=DBUtil.getConnection();PreparedStatement p=c.prepareStatement("DELETE FROM students WHERE student_id=?")){p.setInt(1,id);return p.executeUpdate()==1;}
 }
 private Student map(ResultSet r)throws SQLException{return new Student(r.getInt("student_id"),r.getString("name"),r.getString("email"),r.getString("course"),r.getString("phone"));}
}
