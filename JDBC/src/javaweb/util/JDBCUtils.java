package javaweb.util;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    /**
     * 读取资源文件
     */
    static {
        try {
            ClassLoader classLoader=JDBCUtils.class.getClassLoader();
            URL res=classLoader.getResource("jdbc.properties");
            String path=res.getPath();

            Properties pro=new Properties();
            pro.load(new FileReader(path));


            url = pro.getProperty("url");
            user= pro.getProperty("user");
            password=pro.getProperty("password");
            driver=pro.getProperty("driver");
            //注册驱动
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     *获取连接
     * @return
     */
    public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(url,user,password);
    }

    /**
     * 资源释放
     * @param stat
     * @param conn
     */
    public static void close(Statement stat,Connection conn){
        if (stat!=null){
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 资源释放
     * @param res
     * @param stat
     * @param conn
     */
    public static void close(ResultSet res,Statement stat, Connection conn){
        if (stat!=null){
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (res!=null){
            try {
                res.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
