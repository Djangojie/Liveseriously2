package com.example.diet.bean;

import static org.junit.Assert.*;



import android.util.Log;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBhelperTest {
    private static String diver = "com.mysql.jdbc.Driver";
    //    "jdbc:mysql://⾃⼰电脑的ip地址:端⼝号/数据库名
    private static String url = "jdbc:mysql://192.168.0.103:3306/foodutils?characterEncoding=utf-8";
    private static String userName = "root";//用户名
    private static String password = "123456";//密码
    private static InputStream is ;
    private static FileOutputStream fos;
    public void DBhelperTest() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Log.e("SQL", "找不到jdbc");
        }
        //2、获取与数据库的连接
        Connection connection = null;
        ResultSet set = null;
        Statement statement = null;
        String name,restriction,introduction;

        try {
            connection = DriverManager.getConnection(url, userName, password);
            //3、获取用于向数据库发送sql语句的statement
            statement = connection.createStatement();
            //sql语句
            String sql = "select * from foodutils";
            //4、向数据库发送sql，并获取代表结果集的resultSet
            set = statement.executeQuery(sql);
            String filepath = "";


            //5、取出结果集的数据
            while (set.next()) {
                name =(String) set.getObject("Name");
                restriction =(String) set.getObject("Restriction");
                introduction =(String) set.getObject("introduction");
                System.out.println("Name = " + name);
                System.out.println("Restriction = " + restriction);
                System.out.println("introduction = " + introduction);
//                System.out.println("img = " + set.getObject("img"));
                is = set.getBinaryStream("img");
                filepath = "C:\\Users\\86139\\AndroidStudioProjects\\Diet\\app\\src\\main\\res\\mipmap-foods\\"+name+".jpg";
                fos = new FileOutputStream(filepath);
                byte[] buffer = new byte[1024];
                while (is.read(buffer) > 0) {
                    fos.write(buffer);
                }
            }
            //6、关闭连接，释放资源
            set.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            Log.e("SQL", "数据库连接失败");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

