package edu.campusconnect.web;
import edu.campusconnect.dao.StudentDAO; import edu.campusconnect.model.Student;
import javax.servlet.ServletException; import javax.servlet.annotation.WebServlet; import javax.servlet.http.*;
import java.io.IOException; import java.sql.SQLException;
@WebServlet("/students")
public class StudentServlet extends HttpServlet {
 private StudentDAO dao;
 @Override public void init(){dao=new StudentDAO();}
 @Override protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
  String action=req.getParameter("action");
  try {
   if("new".equals(action)){req.getRequestDispatcher("/WEB-INF/views/student-form.jsp").forward(req,resp);return;}
   if("edit".equals(action)){int id=parseId(req.getParameter("id"));Student s=dao.findById(id);if(s==null){resp.sendError(404,"Student record not found");return;}req.setAttribute("student",s);req.getRequestDispatcher("/WEB-INF/views/student-form.jsp").forward(req,resp);return;}
   req.setAttribute("students",dao.findAll());req.getRequestDispatcher("/WEB-INF/views/student-list.jsp").forward(req,resp);
  }catch(NumberFormatException e){resp.sendError(400,"Invalid student ID");}catch(SQLException e){throw new ServletException("Could not access student records. Check database setup.",e);}
 }
 @Override protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
  req.setCharacterEncoding("UTF-8");String action=req.getParameter("action");
  try {
   if("delete".equals(action)){dao.delete(parseId(req.getParameter("id")));resp.sendRedirect(req.getContextPath()+"/students?message=deleted");return;}
   String name=trim(req.getParameter("name")),email=trim(req.getParameter("email")),course=trim(req.getParameter("course")),phone=trim(req.getParameter("phone"));
   int id=parseOptionalId(req.getParameter("id"));
   if(name.isEmpty()||email.isEmpty()||course.isEmpty()){req.setAttribute("error","Name, email and course are required.");req.setAttribute("student",new Student(id,name,email,course,phone));req.getRequestDispatcher("/WEB-INF/views/student-form.jsp").forward(req,resp);return;}
   Student s=new Student(id,name,email,course,phone);
   if("update".equals(action)){dao.update(s);resp.sendRedirect(req.getContextPath()+"/students?message=updated");}else{dao.insert(s);resp.sendRedirect(req.getContextPath()+"/students?message=added");}
  }catch(NumberFormatException e){resp.sendError(400,"Invalid student ID");}catch(SQLException e){if(e.getErrorCode()==1062){req.setAttribute("error","That email address is already registered.");req.getRequestDispatcher("/WEB-INF/views/student-form.jsp").forward(req,resp);}else throw new ServletException("Could not save student record. Check database setup.",e);}
 }
 private static String trim(String s){return s==null?"":s.trim();}
 private static int parseId(String s){int id=Integer.parseInt(s);if(id<=0)throw new NumberFormatException();return id;}
 private static int parseOptionalId(String s){return s==null||s.isBlank()?0:parseId(s);}
}
