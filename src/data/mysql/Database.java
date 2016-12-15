package data.mysql;

import java.sql.*;

/**
 * Created by ZhangYF on 2016/12/8.
 */
public class Database {
    private static Database ourInstance = new Database();

    public static Database getInstance() {
        return ourInstance;
    }

    private Connection conn;
    private Statement stat;
    private Database() {
    }

    public ResultSet query(String sql){
        ResultSet rs = null;
        conn = DBConnect.getConnection();
        try {
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
//            close();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return rs;
    }

    public boolean execute(String sql){
        conn = DBConnect.getConnection();
        try {
            stat = conn.createStatement();
            stat.executeUpdate(sql);
//            close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public void close(){
        try {
            if(stat != null){
                stat.close();
                stat = null;
            }
            DBConnect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
