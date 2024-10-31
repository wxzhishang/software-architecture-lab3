package database;

import java.sql.*;

@SuppressWarnings("all")
@jdbc(url = "jdbc:mysql:///addresslist", user = "root", password = "root", driver = "com.mysql.jdbc.Driver")
public class JDBCUtils {
    public static Connection getConnection() throws SQLException {
        Class<JDBCUtils> reflectTestClass = JDBCUtils.class;
        jdbc an = reflectTestClass.getAnnotation(jdbc.class);
        try {
            Class.forName(an.driver());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(an.url(), an.user(), an.password());
    }
    public static void close(Statement stmt, Connection conn) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(ResultSet rs, Statement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

