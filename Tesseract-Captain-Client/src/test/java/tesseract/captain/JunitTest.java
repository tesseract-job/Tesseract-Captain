package tesseract.captain;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 * @program: Tesseract-Captain
 * @description:
 * @author: nickle
 * @create: 2019-12-03 09:49
 **/
public class JunitTest {
    @Test
    public void testTableMeta() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tesseract_captain?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=UTC&useJDBCCompliantTimezoneShift=true&allowPublicKeyRetrieval=true", "root", "root");
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet tables = metaData.getTables("tesseract_captain", null, null, null);
        while (tables.next()) {
            String string = tables.getString(3);
            System.out.println(string);
            ResultSet fieldRS = metaData.getColumns("tesseract_captain", null, string, null);
            while (fieldRS.next()) {
                for (int i = 1; i < 10; i++) {
                    System.out.println(i + " " + fieldRS.getString(i));
                }

            }
        }
    }
}
