package Druid.druidtest;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class Druid {
    public static void main(String[] args) throws Exception {
        //加载配置文件
        Properties pro=new Properties();
        InputStream is=Druid.class.getClassLoader().getResourceAsStream("druid.properties");
        pro.load(is);
        //获取链接对象
        DataSource ds= DruidDataSourceFactory.createDataSource(pro);
        Connection conn=ds.getConnection();
        System.out.println(conn);
        conn.close();
    }
}
