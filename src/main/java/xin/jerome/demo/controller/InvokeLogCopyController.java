package xin.jerome.demo.controller;

import oracle.jdbc.driver.OracleConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.jerome.demo.entity.InvokeLogCopy;
import xin.jerome.demo.mapper.InvokeLogCopyMapper;

import javax.annotation.Resource;
import java.sql.*;
import java.util.Date;

/**
 * @author zhangjianyun
 * @title: InvokeLogCopyController
 * @description: TODO
 * @date: 2021/7/16 11:27
 */
@RestController
@RequestMapping("/invokeLogCopy")
public class InvokeLogCopyController {

    @Resource
    private InvokeLogCopyMapper invokeLogCopyMapper;

    @GetMapping("/batchInsert")
    public int batchInsertLog() {
        long timestamp = 1626407001000L;
        int result = 0;
        for (long i = 0; i < 100L; i++) {
            Date date = new Timestamp(timestamp-i*12*3600*1000);
            InvokeLogCopy invokeLogCopy = InvokeLogCopy.builder()
                    .clientId("client"+i)
                    .capCode("cap"+i)
                    .createTime(date)
                    .build();
            int res = invokeLogCopyMapper.insert(invokeLogCopy);
            result += res;

        }
        return result;
    }


    public static Connection getConnection(){
        String url="jdbc:oracle:thin:@192.168.20.200:1521:orcl";
        String username="test_statis";
        String password="test_statis";
        String driver="oracle.jdbc.driver.OracleDriver";
        try {
            Class.forName(driver);
            Connection con= DriverManager.getConnection(url, username, password);
            Statement state=con.createStatement();   //容器
            String sql="select * from invoke_log_copy";   //SQL语句
            ResultSet resultSet= state.executeQuery(sql);         //将sql语句上传至数据库执行
            while (resultSet.next()){
                System.out.println(resultSet.getString(1)+"--"+resultSet.getString(2));
            }
            con.close();//关闭通道
            return con;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        Connection conn= InvokeLogCopyController.getConnection();
    }

}
