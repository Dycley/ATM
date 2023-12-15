package comm;

import java.io.*;
import java.sql.*;
import java.util.Properties;

public class DBLoad {
    static String JDBC_DRIVER ;
    static String DB_URL;

    // 数据库的用户名与密码，需要根据自己的设置
    static String USER;
    static String PASS;

    static {
        try {
            load_config();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public DBLoad() throws IOException {
    }

    public static void load_config() throws IOException{
        InputStream inputStream = new BufferedInputStream(new FileInputStream("./src/config/jdbc.properties"));
        Properties properties = new Properties();
        properties.load(inputStream);
//        properties.list(System.out);
//        System.out.println("==============================================");
        String jdbc_driver = properties.getProperty("jdbc.driver");
        String db_url = properties.getProperty("jdbc.url");
        String user = properties.getProperty("jdbc.username");
        String password = properties.getProperty("jdbc.password");
//        System.out.println("property = " + db_url);
        JDBC_DRIVER=jdbc_driver;
        DB_URL=db_url;
        USER=user;
        PASS=password;
    }
}