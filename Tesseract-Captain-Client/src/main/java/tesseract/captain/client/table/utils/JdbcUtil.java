package tesseract.captain.client.table.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * jdbc工具类
 * @author wesley
 * @create 2019-12-03
 */
public class JdbcUtil {

    public final static Map<String, String> JAVA_TYPE2SQL_TYPE = new HashMap<>();

    static {
        JAVA_TYPE2SQL_TYPE.put("Integer","INT UNSIGNED");
        JAVA_TYPE2SQL_TYPE.put("String","VARCHAR");
        JAVA_TYPE2SQL_TYPE.put("Date" ,"DATETIME");
        JAVA_TYPE2SQL_TYPE.put("Byte","TINYINT");
        JAVA_TYPE2SQL_TYPE.put("Double","double");
        JAVA_TYPE2SQL_TYPE.put("Boolean","tinyint");
    }

}
