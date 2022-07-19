package dao;

import JBCDUtils.JDBCUtils;
import model.Subject;
import model.User;
import model.admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class AdminDAO {
    public static AdminDAO getInstance() {
        return new AdminDAO();
    }

    public boolean check(admin a) {
        Connection conn = JDBCUtils.getConnection();
        try {
            Statement st = conn.createStatement();
            String sql = " SELECT * FROM admin where user=" + "'" + a.getUser() + "'" + "AND password=" + "'" + a.getPassword() + "'";

            ResultSet rs = st.executeQuery(sql);
            if (rs.next() == true) {
                System.out.println("Bạn đã đăng nhập thành công!");
                return true;
            } else {
                return false;
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayList<Subject> SelectAll() {
        ArrayList<Subject> ketQua = new ArrayList<Subject>();
        try {
            Connection conn = JDBCUtils.getConnection();
            Statement st = conn.createStatement();
            String sql = "SELECT * FROM subject";
            System.out.println(sql);
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String idSubject = rs.getString("idSubject");
                String nameSubject = rs.getString("nameSubject");
                int numberOfCredit = rs.getInt("numberOfCredit");
                Subject subject = new Subject(idSubject, nameSubject, numberOfCredit);
                ketQua.add(subject);
            }
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }

    public int insert(Subject sb) {
        int ketQua = 0;
        try {
            Connection conn = JDBCUtils.getConnection();
            Statement st = conn.createStatement();
            String sql = "INSERT INTO  subject(idSubject,nameSubject,numberOfCredit)" + "VALUES('" + sb.getIdSubject() + "','" + sb.getNameSubject() + "'," + sb.getNumberOfCredit() + " )";
            ketQua = st.executeUpdate(sql);
            System.out.println("Bạn đã thực hiện " + sql);
            System.out.println("Có " + ketQua + " dòng bị thay đổi!");
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }

    public int delete(Subject sb) {
        int ketQua = 0;
        try {
            Connection conn = JDBCUtils.getConnection();
            Statement st = conn.createStatement();
            String sql = "DELETE FROM subject" + " WHERE idSubject='" + sb.getIdSubject() + "'";
            ketQua = st.executeUpdate(sql);
            System.out.println("Bạn đã thực hiện câu lệnh " + sql);
            System.out.println("Có " + ketQua + " dòng bị thay đổi");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }

    public ArrayList<User> SelectIdUp() {
        ArrayList<User> ketQua = new ArrayList<User>();
        try {
            Connection conn = JDBCUtils.getConnection();
            Statement st = conn.createStatement();
            String sql = "SELECT id FROM user ORDER BY id ASC";
            System.out.println(sql);
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String id = rs.getString("id");
                User user = new User(id);
                ketQua.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }

    public ArrayList<User> SelectIdDown() {
        ArrayList<User> ketQua = new ArrayList<User>();
        try {
            Connection conn = JDBCUtils.getConnection();
            Statement st = conn.createStatement();
            String sql = "SELECT id FROM user ORDER BY id DESC";
            System.out.println(sql);
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String id = rs.getString("id");
                User user = new User(id);
                ketQua.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }

    public ArrayList<User> SelectNameUp() {
        ArrayList<User> ketQua = new ArrayList<User>();
        try {
            Connection conn = JDBCUtils.getConnection();
            Statement st = conn.createStatement();
            String sql = "SELECT name FROM user ORDER BY name ASC";
            System.out.println(sql);
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String name = rs.getString("name");
                User user = new User();
                user.setName(name);
                ketQua.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }

    public ArrayList<User> SelectNameDown() {
        ArrayList<User> ketQua = new ArrayList<User>();
        try {
            Connection conn = JDBCUtils.getConnection();
            Statement st = conn.createStatement();
            String sql = "SELECT name FROM user ORDER BY name DESC";
            System.out.println(sql);
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String name = rs.getString("name");
                User user = new User();
                user.setName(name);
                ketQua.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }

    public int insertUser(User t) {
        int ketQua = 0;
        try {
            Connection conn = JDBCUtils.getConnection();
            Statement st = conn.createStatement();
            String sql = "INSERT INTO  user(id,password,name)" + "VALUES('" + t.getId() + "','" + t.getPassword() + "'," + t.getName() + " )";
            ketQua = st.executeUpdate(sql);
            System.out.println("Bạn đã thực hiện " + sql);
            System.out.println("Có " + ketQua + " dòng bị thay đổi!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }

    public int updateUser(User t) {
        int ketQua = 0;
        try {
            Connection conn = JDBCUtils.getConnection();
            Statement st = conn.createStatement();
            String sql = "UPDATE  user  SET" +
                    " password='" + t.getPassword() + "'" + ",name= '" + t.getName() + "'" + " where id='" + t.getId() + "'";
            System.out.println(sql);
            ketQua = st.executeUpdate(sql);
            System.out.println("Bạn đã thực hiện " + sql);
            System.out.println("Có " + ketQua + " dòng bị thay đổi!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }

    public int deleteUser(User t) {
        int ketQua = 0;
        try {
            Connection conn = JDBCUtils.getConnection();
            Statement st = conn.createStatement();
            String sql = "DELETE FROM user" + " WHERE id='" + t.getId() + "'";
            ketQua = st.executeUpdate(sql);
            System.out.println("Bạn đã thực hiện câu lệnh " + sql);
            System.out.println("Có " + ketQua + " dòng bị thay đổi");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua;
    }
}

