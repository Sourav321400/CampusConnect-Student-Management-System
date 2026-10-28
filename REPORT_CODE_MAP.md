# Code mapping for report
- Database schema: `database/campusconnect.sql`
- JDBC connection: `src/main/java/edu/campusconnect/util/DBUtil.java`
- Student model: `src/main/java/edu/campusconnect/model/Student.java`
- CRUD queries: `src/main/java/edu/campusconnect/dao/StudentDAO.java`
- HTTP request handling: `src/main/java/edu/campusconnect/web/StudentServlet.java`
- Student listing page: `src/main/webapp/WEB-INF/views/student-list.jsp`
- Add/edit form: `src/main/webapp/WEB-INF/views/student-form.jsp`
- Styles: `src/main/webapp/assets/style.css`

For a real production application, prefer JSTL/EL, authentication, CSRF protection, centralized error handling, and a more robust output-encoding strategy.
