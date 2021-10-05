package JDBCTemplate;

import Druid.Util.DruidUtil;
import org.springframework.jdbc.core.JdbcTemplate;

public class JDBCTemplate1 {
    public static void main(String[] args) {
        JdbcTemplate jt=new JdbcTemplate(DruidUtil.getDs());
        String sql="update user set password=? where id=?";
        int count=jt.update(sql,"987654",3);
        System.out.println(count);
    }
}
