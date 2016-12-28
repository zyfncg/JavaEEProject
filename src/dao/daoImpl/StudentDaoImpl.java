package dao.daoImpl;

import dao.daoService.StudentDao;
import dao.mysql.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Zhang YF on 2016/12/19.
 */
public class StudentDaoImpl implements StudentDao {
    private static StudentDao studentDao = new StudentDaoImpl();
    public static StudentDao getInstance(){
        return studentDao;
    }

    private StudentDaoImpl(){}

    @Override
    public boolean checkPassword(String studentid, String password) {
        PreparedStatement stmt = null;
        ResultSet ret = null;
        Connection conn = DBConnect.getConnection();
        boolean isValid = false;
        try {
            stmt = conn.prepareStatement("select * from student where studentid=? and password=?");
            stmt.setString(1,studentid);
            stmt.setString(2,password);
            ret = stmt.executeQuery();
            if (ret.next()){
                isValid = true;
            }
            ret.close();
            stmt.close();
            DBConnect.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return isValid;
    }
}
