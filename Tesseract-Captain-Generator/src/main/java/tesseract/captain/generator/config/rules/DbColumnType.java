package tesseract.captain.generator.config.rules;

/**
 * 支持的数据库类型枚举
 * @author: LeoLee <zeroming@163.com>
 * @date: 2019/12/4 15:08
 */
public enum DbColumnType implements IColumnType {
    BASE_BYTE("byte", (String)null),
    BASE_SHORT("short", (String)null),
    BASE_CHAR("char", (String)null),
    BASE_INT("int", (String)null),
    BASE_LONG("long", (String)null),
    BASE_FLOAT("float", (String)null),
    BASE_DOUBLE("double", (String)null),
    BASE_BOOLEAN("boolean", (String)null),
    BYTE("Byte", (String)null),
    SHORT("Short", (String)null),
    CHARACTER("Character", (String)null),
    INTEGER("Integer", (String)null),
    LONG("Long", (String)null),
    FLOAT("Float", (String)null),
    DOUBLE("Double", (String)null),
    BOOLEAN("Boolean", (String)null),
    STRING("String", (String)null),
    DATE_SQL("Date", "java.sql.Date"),
    TIME("Time", "java.sql.Time"),
    TIMESTAMP("Timestamp", "java.sql.Timestamp"),
    BLOB("Blob", "java.sql.Blob"),
    CLOB("Clob", "java.sql.Clob"),
    LOCAL_DATE("LocalDate", "java.time.LocalDate"),
    LOCAL_TIME("LocalTime", "java.time.LocalTime"),
    YEAR("Year", "java.time.Year"),
    YEAR_MONTH("YearMonth", "java.time.YearMonth"),
    LOCAL_DATE_TIME("LocalDateTime", "java.time.LocalDateTime"),
    BYTE_ARRAY("byte[]", (String)null),
    OBJECT("Object", (String)null),
    DATE("Date", "java.tesseract.captain.common.util.Date"),
    BIG_INTEGER("BigInteger", "java.math.BigInteger"),
    BIG_DECIMAL("BigDecimal", "java.math.BigDecimal");

    private final String type;
    private final String pkg;

    private DbColumnType(final String type, final String pkg) {
        this.type = type;
        this.pkg = pkg;
    }

    public String getType() {
        return this.type;
    }

    public String getPkg() {
        return this.pkg;
    }
}
