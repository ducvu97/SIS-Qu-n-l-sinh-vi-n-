package test;

import dao.AdminDAO;

import java.util.ArrayList;
import java.util.Scanner;

import dao.UserDAO;
import model.Subject;
import model.User;
import model.admin;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int luachon = 0;
        do {
            System.out.println("------MENU---------");
            System.out.println("Mời bạn chọn chức năng sau: \n" +
                    "1.Đăng nhập với quyền admin \n" +
                    "2.Đăng nhập với quyền user \n" +
                    ".Nhấn bất kì để thoát khỏi chương trình");
            luachon = Integer.parseInt(sc.nextLine());
            if (luachon == 1) {
                boolean a = false;
                do {
                    System.out.println("Nhập vào tên tài khoản");
                    String userAdmin = sc.nextLine();
                    System.out.println("Nhập vào password");
                    String password = sc.nextLine();
                    admin ad = new admin(userAdmin, password);
                    a = AdminDAO.getInstance().check(ad);
                    if (a == true) {
                        System.out.println("Bạn đã đăng nhập thành công");
                    } else {

                        System.out.println("Bạn đã đăng nhập không thành công");
                    }

                } while (a == false);

                int lc1=0;
                do {
                    System.out.println("-----MENU admin------");
                    System.out.println("Mời bạn lựa chọn các chức năng sau\n" +
                            "1.Xem danh sách các môn trong học kì \n" +
                            "2.Thêm môn trong học kì \n" +
                            "3.Xóa môn trong học kì \n" +
                            "4.Xem danh sách thông tin user sắp xếp theo id tăng dần \n" +
                            "5.Xem danh sách thông tin user sắp xếp theo id giảm dần \n" +
                            "6.Xem danh sách thông tin user sắp xếp theo tên tăng dần \n" +
                            "7.Xem danh sách thông tin user sắp xếp theo tên giảm dần \n" +
                            "8.Thêm thông tin user \n" +
                            "9.Sửa thông tin user \n" +
                            "10.Xóa thông tin user \n" +
                            "11.Thoát menu");

                    lc1= Integer.parseInt(sc.nextLine());
                    if(lc1==1){
                        System.out.println("Danh sách các môn trong học kì :");
                        ArrayList<Subject> list =AdminDAO.getInstance().SelectAll();
                        for ( Subject subject:list) {
                            System.out.println(subject);

                        }sc.nextLine();
                    } else if (lc1==2) {
                        System.out.println(" Nhập dữ liệu môn vào đây ");
                        System.out.println("Nhập id môn học ");
                       String idSubject= sc.nextLine();
                        System.out.println("Nhập tên môn học");
                        String nameSubject= sc.nextLine();
                        System.out.println("Nhập số tín chỉ");
                       int numberOfCredit= sc.nextInt();
                        Subject sb= new Subject(idSubject,nameSubject,numberOfCredit);
                        AdminDAO.getInstance().insert(sb);
                    } else if (lc1==3) {
                        System.out.println("Nhập mã môn học cần xóa vào đây");
                        String idSubject= sc.nextLine();
                        Subject sb= new Subject(idSubject);
                        AdminDAO.getInstance().delete(sb);
                    } else if (lc1==4) {
                        System.out.println(" Danh sách user sắp xếp theo id tăng dần là:");
                        ArrayList<User> list = AdminDAO.getInstance().SelectIdUp();
                        for (User user:list){
                            System.out.println(user);
                        }
                    } else if (lc1==5) {
                        System.out.println("Danh sách user sắp xếp theo id giảm dần là:");
                        ArrayList<User> list = AdminDAO.getInstance().SelectIdDown();
                        for (User user:list){
                            System.out.println(user);
                        }
                    } else if (lc1==6) {
                        System.out.println(" Danh sách user sắp xếp theo tên tăng dần là:");
                        ArrayList<User> list = AdminDAO.getInstance().SelectNameUp();
                        for (User user : list) {
                            System.out.println(user.getName());
                        }
                    } else if (lc1==7) {
                        System.out.println(" Danh sách user sắp xếp theo tên giảm dần là:");
                        ArrayList<User> list = AdminDAO.getInstance().SelectNameDown();
                        for (User user : list) {
                            System.out.println(user.getName());
                        }
                    } else if (lc1==8) {
                        System.out.println("Mời nhập thông tin user cần thêm vào đây");
                        System.out.println("Nhập id user ");
                        String id= sc.nextLine();
                        System.out.println("Nhập password user");
                        String password= sc.nextLine();
                        System.out.println("Nhập tên user");
                        String name= sc.nextLine();
                        User user= new User(id,password,name);
                        AdminDAO.getInstance().insertUser(user);

                    } else if (lc1==9) {
                        System.out.println("Mời nhập thông tin user cần sửa vào đây");
                        System.out.println("Nhập id user ");
                        String id= sc.nextLine();
                        System.out.println("Nhập password user");
                        String password= sc.nextLine();
                        System.out.println("Nhập tên user");
                        String name= sc.nextLine();
                        User user= new User(id,password,name);
                        AdminDAO.getInstance().updateUser(user);

                    } else if (lc1==10) {
                        System.out.println("Nhập id user cần xóa vào đây");
                        String id= sc.nextLine();
                        User user= new User(id);
                        AdminDAO.getInstance().deleteUser(user);
                    }
                }while (lc1!=11);
            } else if (luachon==2) {
                boolean a = false;
                do {
                    System.out.println("Nhập vào tên tài khoản user");
                    String id = sc.nextLine();
                    System.out.println("Nhập vào password");
                    String password = sc.nextLine();
                    User user = new User(id, password);
                    a = UserDAO.getInstance().check(user);
                    if (a == true) {
                        System.out.println("Bạn đã đăng nhập thành công");
                    } else {

                        System.out.println("Bạn đã đăng nhập không thành công");
                    }
                    int lc2 = 0;

                    do {
                        System.out.println("----Menu User----");
                        System.out.println("Mời bạn chọn những chức năng sau \n" +
                                "1.Xem danh sách chi tiết môn có thể đăng kí trong kì này \n" +
                                "2.Xem danh sách môn đã đăng kí \n" +
                                "3.Thêm môn vào danh sách đã đăng kí \n" +
                                "4.Xóa môn đã đăng kí \n" +
                                "5.Thoát menu");
//                        lc2=Integer.parseInt(sc.nextLine());
//                       lc2=Integer.valueOf(sc.nextLine());
                        lc2 = sc.nextInt();
                        sc.nextLine();
                        if (lc2 == 1) {
//                      
                            for (Subject subject : UserDAO.getInstance().selectIdSubjectNotRegister(user.getId())) {
                                System.out.println(subject);
                            }
                        } else if (lc2 == 2) {
                            for (Subject subject : UserDAO.getInstance().selectIdSubjectRegister(user.getId())) {
                                System.out.println(subject);
                            }
                        } else if (lc2 == 3) {
                            int c = 0;
                            do {
                                System.out.println("Mời nhập thông tin môn học vào đây");
                                System.out.println("Nhập số tín chỉ môn học");
                                int numberOfCredit = sc.nextInt();
                                System.out.println("Nhập id môn học");
                                sc.nextLine();
                                String idSubject = sc.nextLine();
                                System.out.println("Nhập tên môn học");
                                String nameSubject = sc.nextLine();
                                Subject subject = new Subject(idSubject, nameSubject, numberOfCredit);
                                c=UserDAO.getInstance().insertSubjectRegister(subject, user.getId());

                            } while (c > 24);
                        } else if (lc2==4) {
                            System.out.println("Nhập vào id môn học cần xóa");
                            String idSubject= sc.nextLine();
                            Subject subject=new Subject(idSubject);
                            UserDAO.getInstance().deleteSubjectRegister(subject,user.getId());
                        }
                    }while (lc2 != 5) ;

                    } while (a == false);
                }


                }while (luachon !=1||luachon!=2) ;
            System.out.println("Bạn đã thoát chương trình");

    }
}