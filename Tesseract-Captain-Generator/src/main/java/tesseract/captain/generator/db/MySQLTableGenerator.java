package tesseract.captain.generator.db;

import tesseract.captain.generator.config.SQLConfigBuilder;
import tesseract.captain.generator.db.sql.MySqlTableSqlGenerator;
import tesseract.captain.generator.po.GraphMap;

/**
 * MySQL表生成器
 * @author: LeoLee <zeroming@163.com>
 * @date: 2019/12/4 09:24
 */
public class MySQLTableGenerator extends AbstractTableGenerator{


    @Override
    public Boolean doExecuteSQL(GraphMap graphMap, SQLConfigBuilder sqlConfigBuilder) {
        String sql = parseSQL(graphMap);
        // TODO 获取数据源,写入数据库
        return false;
    }

    @Override
    public String parseSQL(GraphMap graphMap) {
        MySqlTableSqlGenerator mySqlTableSqlGenerator = new MySqlTableSqlGenerator(graphMap);
        return mySqlTableSqlGenerator.generatorSql();
    }


}

