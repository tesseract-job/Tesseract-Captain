package tesseract.captain.client.table.validator;

import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

/**
 * @program: Tesseract-Captain
 * @description: mysql 验证器
 * @author: nickle
 * @create: 2019-12-03 10:15
 **/
@Slf4j
public class MysqlTableValidator implements ITableValidator {
    @Override
    public boolean validateTable(Connection conn, String dbName, Class<?> clazz) {
        boolean flag = true;
        try {
            DatabaseMetaData metaData = conn.getMetaData();
            String clazzName = clazz.getName();
            ResultSet tableRS = metaData.getTables(dbName, null, clazzName, null);
            if (!tableRS.next()) {
                //创建表
                flag = false;
                createTable(conn, clazz);
            }
        } catch (Exception e) {
        }
        return flag;
    }

    private void createTable(Connection conn, Class<?> clazz) throws Exception {

    }

    @Override
    public boolean validateField(Connection conn, String dbName, String tableName, Class<?> clazz) {
        boolean flag = true;
        return flag;
    }
}
