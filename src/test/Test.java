package test;

import dao.AdminDAO;
import dao.UserDAO;
import model.Subject;
import model.User;
import model.admin;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
//        admin ad = new admin("dongnv","dong123");
//        AdminDAO addao= new AdminDAO();
//
//        System.out.println(addao.check(ad));
//        ArrayList<Subject> list = new ArrayList<>();
//        list = AdminDAO.getInstance().SelectAll();
//        for (Subject subject : list) {
//            System.out.println(subject);
//        }
User user= new User("ABC123","yeuem1997");
UserDAO.getInstance().check(user);
        Subject sb = new Subject("DB3");
//        AdminDAO.getInstance().insert(sb);
//        AdminDAO.getInstance().delete(sb);
//
//        User user = new User("ABC123", "yeuem1997", "Vũ Ngọc Lâm");
//
//        for (Subject subject: UserDAO.getInstance().selectIdSubjectRegister("ABC123")){
//            System.out.println(subject);
//        }
//        UserDAO.getInstance().insertSubjectRegister(sb,user.getId());
UserDAO.getInstance().deleteSubjectRegister(sb, user.getId());
    }
}
