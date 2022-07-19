package dao;

import model.Subject;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;

public interface DAOInterface<T> {
 public int insert(T t);

 int insert(Subject sb);

 public int update(T t);
 public int delete(T t);

 int deleteSubjectRegister(Subject sb, String t);

 public ArrayList<T> selectAll();
 public T selectByID();
 public ArrayList<T> selectByCondition( String Condition);



}
