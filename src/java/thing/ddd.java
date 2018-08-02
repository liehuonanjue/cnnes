package thing;

import org.junit.jupiter.api.Test;
import shiwu.BankDaoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ddd extends BaseDAO {


    public void fromToBank(String name, double money) {
        try {

            String sql = "UPDATE bank SET money=money+? WHERE `name`=?";
            Object[] params = {money, name};
            int num = executeUpdate(sql, params);
            if (num > 0) {
                System.out.println("成功");
            } else {
                System.out.println("失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void text2() throws Exception {
        try {
            super.con = getConnection(); //连接sql方法
            con.setAutoCommit(false); //关闭自动提交事务
            fromToBank("小黑", -1000);
            if (true) {
                throw new Exception("转账失败========");
            }
            fromToBank("小白", 1000);
            con.commit(); //事物提交
        } catch (Exception e) {
            e.printStackTrace();
            try {
                con.rollback(); //事物回滚
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        }
    }

}
