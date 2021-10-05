package javaweb.JDBC;

import javaweb.util.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

/**
 * 登录数据库
 */
public class JDBCDenglu {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名：");
        String name= sc.next();
        System.out.println("请输入密码");
        String password= sc.next();
        boolean fl=new JDBCDenglu().denglu2(name,password);
        if (fl){
            System.out.println("登录成功");
        }else{
            System.out.println("登录失败，用户名或密码错误！");
        }
    }

    public boolean denglu(String usernames,String passwordes){
        if (usernames==null||passwordes==null) {
            return false;
        }
        Statement stat=null;
        Connection conn=null;
        ResultSet res=null;
        try {
            conn=JDBCUtils.getConnection();
            String sql="select * from user where username='"+usernames+"' and password='"+passwordes+"'";
            stat=conn.createStatement();
            res=stat.executeQuery(sql);
            return res.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(res,stat,conn);
        }
        return false;
    }
    public boolean denglu2(String usernames,String passwordes){
        if (usernames==null||passwordes==null) {
            return false;
        }
        PreparedStatement pstat=null;
        Connection conn=null;
        ResultSet res=null;
        try {
            conn=JDBCUtils.getConnection();
            String sql="select * from user where username=? and password=?";
            pstat=conn.prepareStatement(sql);
            //PreparedStatement能防止SQL注入，而且效率更高
            pstat.setString(1,usernames);
            pstat.setString(2,passwordes);
            res= pstat.executeQuery();
            return res.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(res,pstat,conn);
        }
        return false;
    }
}
