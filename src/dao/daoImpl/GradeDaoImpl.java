package dao.daoImpl;

import dao.daoService.GradeDao;
import dao.mysql.DBConnect;
import model.Grade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhang YF on 2016/12/15.
 */
public class GradeDaoImpl implements GradeDao {

    private static GradeDaoImpl gradeDao = new GradeDaoImpl();
    private static Connection conn;
    private GradeDaoImpl() {

    }

    public static GradeDao getInstance(){
        return gradeDao;
    }
    @Override
    public List<Grade> getGradeList(String studentid) {
        PreparedStatement stmt = null;
        ResultSet ret = null;
        List<Grade> list = new ArrayList<>();
        conn = DBConnect.getConnection();
        try {
            stmt = conn.prepareStatement("select * from gradeView where studentid=?");
            stmt.setString(1,studentid);
            ret = stmt.executeQuery();
            while (ret.next()){
                String courseName = ret.getString("coursename");

                double exam = ret.getDouble("exam");
                double lab = ret.getDouble("lab");
                double score = ret.getDouble("grade");
                Grade grade = new Grade(studentid,courseName,exam,lab,score);
                if(ret.getString("grade") == null){
                    grade.setTest(false);
                }
                list.add(grade);
            }
            ret.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
