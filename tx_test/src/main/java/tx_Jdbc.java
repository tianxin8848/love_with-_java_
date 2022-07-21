
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


public class tx_Jdbc {
    //通过jdbc连接数据库
    private static Connection getConn() {

        String driver = "com.mysql.cj.jdbc.Driver";
        //下面的变量设置根据自己的情况
     //  String url = "jdbc:mysql://localhost:3306/tx_javatest?useSSL=false"; //数据库是webone
        String url ="jdbc:mysql://localhost:3306/tx_javatest.qq?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai";

        String username = "root";
        String password = "mima";

        Connection conn = null;

        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }


    static int insert( List<String> list ) {

        Connection conn = getConn();
        int i = 0;

        //往表QQ中添加属性email
        String sql = "insert into QQ (email) values(?)";
        PreparedStatement pstmt;

        try {

            //表示预编译的sql对象
            pstmt = (PreparedStatement) conn.prepareStatement(sql);

            for (int j = 0; j < list.size(); j++) {
                pstmt.setString(1, list.get(j));
                i = pstmt.executeUpdate();
                pstmt.close();
                //conn.commit();
                conn.setAutoCommit(false);

                conn.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return i;
    }


}
