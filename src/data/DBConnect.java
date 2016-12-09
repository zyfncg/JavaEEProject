package data;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by ZhangYF on 2016/12/8.
 */
public class DBConnect {
    private static InitialContext ctx;
    private static DataSource ds;
    private static Connection conn = null;

    private DBConnect() {}

    public static Connection getConnection(){
        if(conn == null){
            try {
                ctx = new InitialContext();
                ds = (DataSource) ctx.lookup("java:comp/env/jdbc/j2ee");
                conn = ds.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (NamingException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    public static void close(){
        try {
            if(conn != null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        conn = null;
    }
}
