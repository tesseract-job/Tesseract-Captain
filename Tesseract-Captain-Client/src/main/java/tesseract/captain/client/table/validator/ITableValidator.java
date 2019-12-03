package tesseract.captain.client.table.validator;

import java.sql.Connection;
import java.sql.DatabaseMetaData;

/**
 * @program: Tesseract-Captain
 * @description: 检测数据库表是否存在，字段是否修改，遵循以下规则：
 * 1、如果表不存在则创建表
 * 2、如果表属性不存在则添加
 * 3、如果表属性添加了别名，则修改属性名为别名
 * @author: nickle
 * @create: 2019-12-03 09:44
 **/
public interface ITableValidator {
    /**
     * 验证表，不存在则创建
     *
     * @param conn   数据库连接
     * @param dbName 数据库名
     * @param clazz  验证的实体类
     * @return 是否验证成功
     */
    boolean validateTable(Connection conn, String dbName, Class<?> clazz);

    /**
     * 验证字段，不存在则创建
     *
     * @param conn      数据库连接
     * @param dbName    数据库名
     * @param tableName 表名
     * @param clazz     验证的实体类
     * @return 是否验证成功
     */
    boolean validateField(Connection conn, String dbName, String tableName, Class<?> clazz);

}
