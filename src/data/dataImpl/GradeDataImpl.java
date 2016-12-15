package data.dataImpl;

import data.dataService.GradeDataService;
import data.mysql.DBConnect;
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
public class GradeDataImpl implements GradeDataService {
    PreparedStatement stmt = null;
    ResultSet ret = null;
    @Override
    public List<Grade> getGradeList(String studentid) {
        List list = new ArrayList();
        Connection conn = getConnect();
        try {
            stmt = conn.prepareStatement("select * from gradeView where studentid=?");
            stmt.setString(1,studentid);
            ret = stmt.executeQuery();
            while (ret.next()){
                String courseName = ret.getString("coursename");
                double score = ret.getDouble("grade");
                Grade grade = new Grade(studentid,courseName,score);
                list.add(grade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    private Connection getConnect(){
        return DBConnect.getConnection();
    }

}
