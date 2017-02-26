package edu.nju.j2ee.dao.daoImpl;

import edu.nju.j2ee.dao.daoService.BaseDao;
import edu.nju.j2ee.dao.daoService.StudentDao;
import edu.nju.j2ee.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Zhang YF on 2016/12/19.
 */
@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private BaseDao baseDao;


    @Override
    public boolean checkPassword(String studentid, String password) {
        boolean isValid;

        Student student = (Student) baseDao.load(Student.class,studentid);
        isValid = password.equals(student.getPassword());
        return isValid;
    }

    @Override
    public List<Student> getStudent(){
        return null;
    }

}
