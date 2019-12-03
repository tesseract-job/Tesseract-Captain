package tesseract.captain.client.table.validator;

import lombok.extern.slf4j.Slf4j;
import tesseract.captain.client.table.annotation.FieldAlias;
import tesseract.captain.client.table.utils.JdbcUtil;
import tesseract.captain.client.table.utils.StringUtil;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        Field[] fields = clazz.getFields();
        String tableName = StringUtil.camelToUnderline(clazz.getName());
        StringBuilder sb = new StringBuilder("create table " + tableName + "("+"\n");
        for (Field field : fields) {
            field.setAccessible(true);
            String fieldName = field.getName();
            Class<?> fieldType = field.getType();
            sb.append("\t\t"+fieldName+" "+ JdbcUtil.JAVA_TYPE2SQL_TYPE.get(fieldType)+",\n");
        }
        sb.append(")");
        conn.prepareStatement(sb.toString());
    }

    @Override
    public boolean validateField(Connection conn, String dbName, String tableName, Class<?> clazz) {
        boolean flag = true;
        try {
            DatabaseMetaData metaData = conn.getMetaData();
            ResultSet tableRS = metaData.getTables(dbName, null, tableName, null);
            Field[] fields = clazz.getFields();
            int length = fields.length;
            int rsRow = tableRS.getRow();
            if (length != rsRow){
                for (Field field : fields) {
                    field.setAccessible(true);
                    String fieldName = field.getName();
                    Class<?> fieldType = field.getType();
                    FieldAlias fieldAlias = field.getAnnotation(FieldAlias.class);
                    while (!tableRS.next()){
                        if (fieldName != tableRS.getString("COLUMN_NAME") && fieldAlias == null){
                            String sql = "alter "+ tableName+" add "+ fieldName + JdbcUtil.JAVA_TYPE2SQL_TYPE.get(fieldType)+";";
                            conn.prepareStatement(sql);
                        }
                    }
                }
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * 修改数据库的属性，遵循以下规则：
     *  1、如果表属性不存在则添加
     *  2、如果表属性添加了别名，则修改属性名为别名
     * @param conn      数据库连接
     * @param dbName    数据库名
     * @param tableName 表名
     * @param clazz     验证的实体类
     */
    private void modifyField(Connection conn, String dbName, String tableName, Class<?> clazz){
        if (validateField(conn,dbName,tableName,clazz)){
            try {
                DatabaseMetaData metaData = conn.getMetaData();
                ResultSet tableRS = metaData.getTables(dbName, null, tableName, null);
                Field[] fields = clazz.getFields();
                for (Field field : fields) {
                    String fieldName = field.getName();
                    FieldAlias fieldAlias = field.getAnnotation(FieldAlias.class);
                    if (fieldAlias != null){
                        String oldName = fieldAlias.value();
                        String sql = "alter "+ tableName+" rename "+ oldName + " to" + fieldName+";";
                        conn.prepareStatement(sql);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
