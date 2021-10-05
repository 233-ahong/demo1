package Druid.druidtest;

import Druid.Util.DruidUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DruidTest {
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement pstat=null;
        try {
            conn=DruidUtil.getConnection();
            String sql="insert into user value(null,?,?)";
            pstat=conn.prepareStatement(sql);
            pstat.setString(1,"wangwu");
            pstat.setString(2,"1234");
            int count=pstat.executeUpdate();
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DruidUtil.close(pstat,conn,null);
        }
    }

}
