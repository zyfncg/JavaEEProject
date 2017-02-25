package dao.daoImpl;

import dao.daoService.StudentDao;
import dao.hibernateSession.SessionConnect;
import model.Student;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Zhang YF on 2016/12/19.
 */
public class StudentDaoImpl implements StudentDao {

    private Session session;


    private static StudentDao studentDao = new StudentDaoImpl();
    public static StudentDao getInstance(){
        return studentDao;
    }

    private StudentDaoImpl(){}

    @Override
    public boolean checkPassword(String studentid, String password) {
        boolean isValid;
        session = SessionConnect.getSession();
        Student student = session.find(Student.class,studentid);
        session.close();
        isValid = password.equals(student.getPassword());
        return isValid;
    }

    @Override
    public List<Student> getStudent(){
        session = SessionConnect.getSession();
        List<Student> students = session.createQuery("from Student ").list();
        session.close();
        return students;
    }

}
