import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

/**
 * @desc:  写入Mysql数据库了连接信息到jdbc.properties中
 * @author: cao_wencao
 * @date: 2020-12-29 13:41
 */
public class Test {
    public static void main(String[] args) {
        Properties properties = new Properties();
        OutputStream output = null;
        try {
            output = new FileOutputStream("src/config/jdbc.properties");
            properties.setProperty("jdbc.driver", "com.mysql.cj.jdbc.Driver");
            properties.setProperty("jdbc.url","jdbc:mysql://localhost:3306/myatmdb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC" );
            properties.setProperty("jdbc.username", "root");
            properties.setProperty("jdbc.password", "123456");

            // 保存键值对到文件中
            properties.store(output, "config of db");

        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
