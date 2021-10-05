package Druid.Util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Druid工具类
 */
public class DruidUtil {
    public static DataSource ds;
    static {
        try {
            //加载配置文件
            Properties pro=new Properties();
            pro.load(DruidUtil.class.getClassLoader().getResourceAsStream("druid.properties"));
            //获取DataSource
            ds=  DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //获取连接
    public static Connection getConnection() throws SQLException {
        return  ds.getConnection();
    }
    //释放资源
    public static void close(Statement stat, Connection conn, ResultSet res){
        if(stat!=null){
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(res!=null){
            try {
                res.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static DataSource getDs(){
        return ds;
    }

}
