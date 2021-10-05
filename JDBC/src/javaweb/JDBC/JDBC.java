package javaweb.JDBC;

import javaweb.util.JDBCUtils;

import java.sql.*;

public class JDBC {
    public static void main(String[] args) {
        Connection conn=null;
        Statement stat=null;
        ResultSet res=null;
        try {
            conn=JDBCUtils.getConnection();
            String sql="select * from l1";
            stat=conn.createStatement();
            res = stat.executeQuery(sql);
            while (res.next()){
                int id=res.getInt(1);
                String s=res.getString(2);
                System.out.println(id+"---"+s);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        JDBCUtils.close(res,stat,conn);
    }
}
/*数据修改
public class JDBC {
    public static void main(String[] args) {
        Connection conn=null;
        Statement stat=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///d1", "root", "123456");
            String sql="update l1 set student_name=6 where email=1";
            stat=conn.createStatement();
            int count = stat.executeUpdate(sql);
            System.out.println(count);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stat!=null){
                try {
                    stat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}*/
/*数据插入
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {

    public static void main(String[] args) {
        Connection conn=null;
        Statement stat=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String sql="INSERT INTO l1 VALUE(2,'3','m','2','3','123')";
            conn = DriverManager.getConnection("jdbc:mysql:///d1", "root", "123456");
            stat = conn.createStatement();
            int count = stat.executeUpdate(sql);
            System.out.println(count);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (stat!=null) {
                try {
                    stat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn!=null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}*/


