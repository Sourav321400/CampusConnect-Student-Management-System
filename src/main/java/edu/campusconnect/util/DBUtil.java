package edu.campusconnect.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public final class DBUtil {
 private static final String DEFAULT_URL="jdbc:mysql://localhost:3306/campusconnect?useSSL=false&serverTimezone=UTC";
 private DBUtil() {}
 public static Connection getConnection() throws SQLException {
  String url=System.getenv().getOrDefault("CAMPUSCONNECT_DB_URL",DEFAULT_URL);
  String user=System.getenv().getOrDefault("CAMPUSCONNECT_DB_USER","root");
  String password=System.getenv("CAMPUSCONNECT_DB_PASSWORD");
  if(password==null || password.isBlank()) throw new SQLException("Set CAMPUSCONNECT_DB_PASSWORD environment variable.");
  return DriverManager.getConnection(url,user,password);
 }
}
