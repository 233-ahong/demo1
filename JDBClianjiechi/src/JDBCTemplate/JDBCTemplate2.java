package JDBCTemplate;

import Druid.Util.DruidUtil;
import JDBCTemplate.Emp.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class JDBCTemplate2 {
    private JdbcTemplate jt=new JdbcTemplate(DruidUtil.getDs());
    private String sql=null;
    @Test
    public void test1(){
        String sql="insert into user value(null,?,?)";
        int count=jt.update(sql,"blue","23456");
        System.out.println(count);
    }
    @Test
    public void test2(){
        sql="delete from user where id=?";
        int count=jt.update(sql,3);
        System.out.println(count);
    }
    @Test
    public void test3(){
        sql="select * from user where id=?";
        //查询结果集返回值长度只能是1（即一行）
        Map<String, Object> map = jt.queryForMap(sql, 2);
        System.out.println(map);
    }
    @Test
    public void test4(){
        sql="select * from user";
        //将每一条记录封装成Map再装在List里面
        List<Map<String, Object>> maps = jt.queryForList(sql);
        for (Map<String, Object>stringObjectMap:maps){
            System.out.println(stringObjectMap);
        }
    }
    @Test
    public void test5(){
        sql="select * from user";
        //Java自己实现封装
        List<Emp> list = jt.query(sql, new BeanPropertyRowMapper<>(Emp.class));
        for (Emp emp:list) {
            System.out.println(emp);
        }
    }
    @Test
    public void test6(){
        sql="select count(id) from user";
        //查看聚合函数
        Long taol = jt.queryForObject(sql, Long.class);
        System.out.println(taol);
    }
}
