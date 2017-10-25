package uow.csse.bptzz.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class test {
    public static void testconn() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance(); //MYSQL驱动
            Connection con = DriverManager.getConnection("jdbc:mysql://ca-cdbr-azure-central-a.cloudapp.net:3306/pro611db", "bfa57f3b0eddae", "c759e708"); //链接本地MYSQL
            System.out.println("yes");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void selectremotedata() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance(); //MYSQL驱动
            Connection con = DriverManager.getConnection("jdbc:mysql://ca-cdbr-azure-central-a.cloudapp.net:3306/pro611db", "bfa57f3b0eddae", "c759e708"); //链接本地MYSQL
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM bptzz_student;");
            int ret_id;
            if (res.next()) {
                ret_id = res.getInt(1);
                System.out.print(ret_id);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertdata() {
        try {
            Connection con = null; //定义一个MYSQL链接对象
            Class.forName("com.mysql.jdbc.Driver").newInstance(); //MYSQL驱动
            //con = DriverManager.getConnection("jdbc:mysql://ca-cdbr-azure-central-a.cloudapp.net:3306/pro611db", "bfa57f3b0eddae", "c759e708"); //链接本地MYSQL
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jpa_sample", "root", "ttxy"); //链接本地MYSQL

            Statement stmt; //创建声明
            stmt = con.createStatement();

            //新增一条数据
            //stmt.executeUpdate("INSERT INTO `bptzz_student` VALUES ('2014532', 'JACK', 'WANG', null, 'M', '1995-10-01', '1325 Sunset ave', null, '2015', '4.00', '001'), ('2015003', 'James', 'JIANG', null, 'M', '1993-03-17', '783 peter st', null, '2015', '2.00', '003'), ('2015098', 'Chris', 'FENG', null, 'F', '1993-06-17', '617 bridge', null, '2015', '8.00', '004'), ('2016389', 'Bruce', 'KUANG', null, 'M', '1995-10-08', '356 campbell', null, '2016', '6.00', '002'), ('2016678', 'Mary', 'HO', null, 'F', '1994-02-19', '789 bridge ave', null, '2016', '5.00', '001'), ('2016783', 'Temo', 'ANGER', null, 'F', '1995-10-01', '783 peter st', null, '2016', '4.00', '003'), ('2017043', 'Lily', 'HU', null, 'F', '1997-07-03', '532 josephine ave', null, '2017', '7.00', '002'), ('2017623', 'Victor ', 'ZHANG', null, 'M', '1995-02-03', '298 california', null, '2017', '4.00', '002');");
            stmt.executeUpdate("INSERT INTO `user` VALUES ('5', 'testjdbc', 'fortest');");
            ResultSet res = stmt.executeQuery("SELECT LAST_INSERT_ID()");
            int ret_id;
            if (res.next()) {
                ret_id = res.getInt(1);
                System.out.print(ret_id);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main( String [ ] args ) {

        testconn();
        selectremotedata();
        insertdata();
    }
}
