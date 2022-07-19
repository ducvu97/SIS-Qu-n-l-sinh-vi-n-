package dao;

import JBCDUtils.JDBCUtils;
import model.Subject;
import model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDAO implements DAOInterface<User> {
    private String user;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public static UserDAO getInstance() {
        return new UserDAO();
    }
    public  boolean check(User t){
        setUser(t.getId());
        System.out.println(getUser());
        Connection conn = JDBCUtils.getConnection();
        try {
            Statement st = conn.createStatement();
            String sql = " SELECT * FROM user where id=" + "'" + t.getId() + "'" + "AND password=" + "'" + t.getPassword() + "'";
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

    @Override
    public int insert(User user) {
        return 0;
    }

    @Override
    public int insert(Subject sb) {
        return 0;
    }

    public int insertSubjectRegister(Subject sb, String t) {
        int sum=0,sum1 = 0,sum2= 0;
        int ketQua = 0;
        try {

            Connection conn = JDBCUtils.getConnection();
            Statement st = conn.createStatement();
            String sql="SELECT numberOfCredit FROM subjectregister where iduser='"+ t +"'";
            System.out.println(sql);
            ResultSet rs=st.executeQuery(sql);
            while (rs.next()) {
                int numberOfCredit = rs.getInt("numberOfCredit");
                sum1 = sum1+ numberOfCredit;
                sum2= sb.getNumberOfCredit();
                sum=sum1+sum2;

            }
                if (sum<=24){
                    System.out.println("Mời nhập môn học");
                    String sql1= "INSERT INTO  subjectregister(idSubject,nameSubject,numberOfCredit,iduser)" + "VALUES('"+ sb.getIdSubject() + "','" + sb.getNameSubject() + "'," + sb.getNumberOfCredit() + ", '"+t+" ')";
                    ketQua = st.executeUpdate(sql1);
                    System.out.println("Bạn đã thực hiện " + sql1);
                    System.out.println("Có " + ketQua + " dòng bị thay đổi!");

                }else {
                    System.out.println("Bạn đã đăng kí quá số tín chỉ");

                }
                conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sum;

    }

    @Override
    public int update(User user) {
        return 0;
    }

    @Override
    public int delete(User user) {
        return 0;
    }

    @Override
    public int deleteSubjectRegister(Subject sb, String t) {
        int ketQua = 0;
        try {
            Connection conn = JDBCUtils.getConnection();
            Statement st = conn.createStatement();
            String sql = "DELETE FROM subjectregister" + " WHERE idSubject='" + sb.getIdSubject() +"'" + "AND iduser="+"'"+t+"'";
            ketQua = st.executeUpdate(sql);
            System.out.println("Bạn đã thực hiện câu lệnh " + sql);
            System.out.println("Có " + ketQua + " dòng bị thay đổi");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua;

    }

    @Override
    public ArrayList<User> selectAll() {
        return null;
    }
public ArrayList<Subject> selectIdSubjectRegister(String t){
        ArrayList<Subject> ketQua= new ArrayList<>();
        try {
            Connection conn=JDBCUtils.getConnection();
            Statement st= conn.createStatement();
            String sql="SELECT idsubject,nameSubject,numberOfCredit FROM subjectregister where iduser='" + t + "'";
            System.out.println(sql);
            ResultSet rs= st.executeQuery(sql);
            while (rs.next()){
                String id=rs.getString("idsubject");
                String nameSubject=rs.getString("nameSubject");
                int numberOfCredit=rs.getInt("numberOfCredit");
                Subject sb= new Subject(id,nameSubject,numberOfCredit);
                ketQua.add(sb);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    return ketQua;
}

    public ArrayList<Subject> selectIdSubjectNotRegister(String t) {
        ArrayList<String> ketQua = new ArrayList<String>();
        ArrayList<Subject> ketQua2 = new ArrayList<Subject>();
        try {
            Connection conn = JDBCUtils.getConnection();
            Statement st = conn.createStatement();
            String sql = "SELECT idsubject FROM subjectregister where iduser='" + t + "'";
            // System.out.println(sql);
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String id = rs.getString("idsubject");
                ketQua.add(id);
            }
            String sql0="" ;

            for (String idsubject : ketQua) {
                sql0 = sql0 + " not idSubject = '" + idsubject + "' AND ";
            }
            String sql2 = sql0.substring(0, sql0.lastIndexOf("AND"));
            // System.out.println(sql1);
            String sql1 = "SELECT * FROM subject where " + sql2;
            System.out.println(sql1);
            ResultSet rs1 = st.executeQuery(sql1);
            while (rs1.next()){
                String idSubject= rs1.getString("idSubject");
                String nameSubject=rs1.getString("nameSubject");
                int nameOfCredit=rs1.getInt("numberOfCredit");
               Subject sb =new Subject(idSubject,nameSubject,nameOfCredit) ;
               ketQua2.add(sb);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ketQua2;
    }


    @Override
    public User selectByID() {
        return null;
    }

    @Override
    public ArrayList<User> selectByCondition(String Condition) {
        return null;
    }
}
