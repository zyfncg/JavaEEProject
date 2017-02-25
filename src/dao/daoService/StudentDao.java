package dao.daoService;

import model.Student;

import java.util.List;

/**
 * Created by Zhang YF on 2016/12/19.
 */
public interface StudentDao {
    public boolean checkPassword(String userid, String password);
    public List<Student> getStudent();
}
