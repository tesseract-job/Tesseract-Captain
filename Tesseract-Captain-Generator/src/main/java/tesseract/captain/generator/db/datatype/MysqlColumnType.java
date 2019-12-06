package tesseract.captain.generator.db.datatype;

/**
 * @author: LeoLee <zeroming@163.com>
 * @date: 2019/12/5 11:50
 */
public enum MysqlColumnType implements IColumnType {

    BIT(1,"bit","java.lang.Boolean"),
    TINYINT(2,"tinyint","java.lang.Integer"),
    SMALLINT(3,"smallint","java.lang.Integer"),
    MEDIUMINT(4,"mediumint","java.lang.Integer"),
    INT(5,"int","java.lang.Integer"),
    INTEGER(6,"integer", "java.lang.Long"),
    BIGINT(7,"bigint","java.math.BigInteger"),
    FLOAT(8,"float","java.lang.Float"),
    DOUBLE(9,"double","java.lang.Double"),
    DECIMAL(10,"decimal","java.math.BigDecimal"),

    DATE(11,"date", "java.util.Date"),
    TIME(12,"time", "java.sql.Timestamp"),
    DATETIME(13,"datetime", "java.util.Date"),
    TIMESTAMP(14,"timestamp", "java.util.Date"),
    YEAR(15,"year", "java.time.Year"),

    TINYBLOB(16,"TINYBLOB", "byte[]"),
    BLOB(17,"blob", "byte[]"),
    MEDIUMBLOB(18,"mediumblob", "java.lang.String"),
    LONGBLOB(19,"longblob", "java.lang.String"),
    CHAR(20,"char", "java.lang.String"),
    VARCHAR(21,"varchar", "java.lang.String"),
    TINYTEXT(22,"tinytext","java.lang.String"),
    TEXT(23,"text","java.lang.String"),
    LONGTEXT(24,"longtext", "java.lang.String"),
    MEDIUMTEXT(25,"mediumtext", "java.lang.String"),
    BIG_DECIMAL(26,"BigDecimal", "java.math.BigDecimal");

    private final int value;
    private final String type;
    private final String pkg;

    private MysqlColumnType(final int value, final String type, final String pkg) {
        this.value = value;
        this.type = type;
        this.pkg = pkg;
    }


    @Override
    public String getType() {
        return this.type;
    }
    @Override
    public String getPkg() {
        return this.pkg;
    }

    public static IColumnType getTypeByValue(Integer value) {
        for(MysqlColumnType columnType:MysqlColumnType.values()){
            if(value == columnType.value){
                return columnType;
            }
        }
        return null;
    }

}
