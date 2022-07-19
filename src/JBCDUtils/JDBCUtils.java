package JBCDUtils;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtils {
  public static Connection getConnection(){
      Connection conn =null;
      try {
          DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
          String url = "jdbc:mySQL://localhost:3306/sis";
          String username = "root";
          String password = "123456789";
          conn = DriverManager.getConnection(url,username,password);
      } catch (SQLException e) {
          throw new RuntimeException(e);
      }
      return conn;
  }
}
