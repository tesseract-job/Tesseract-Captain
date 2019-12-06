package tesseract.captain.generator.db.sql;

import tesseract.captain.generator.db.datatype.IColumnType;
import tesseract.captain.generator.db.datatype.MysqlColumnType;
import tesseract.captain.generator.po.GraphMap;
import tesseract.captain.server.model.dto.GraphNode;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Mysql建表语句生成器
 * @author: LeoLee <zeroming@163.com>
 * @date: 2019/12/5 12:05
 */
public class MySqlTableSqlGenerator implements ITableSqlGenerator{

    // 数据库编码格式
    public static final String DEFAULT_CHARSET ="utf8";
    public static final String DEFAULT_COLLATE ="utf8_general_ci";
    // 创建表头语句
    public static final String CREATE_TABLE_FORMAT = "CREATE TABLE `%s` (%s) DEFAULT CHARSET=%s COLLATE=%s  COMMENT= '%s';";
    // 字段格式化
    public static final String FIELD_FORMAT = " `%s` %s %s %s COMMENT '%s' %s";
    // 字段默认值
    public static final String FIELD_DEFAULT_VALUE = "DEFAULT '%s' ";
    // 自增
    public static final String AUTO_INCREMENT = "AUTO_INCREMENT ";
    // 行分隔符
    public static final String LINE_COMMA = ", ";
    // 主键
    public static final String PRIMARY_KEY= " ,PRIMARY KEY (`%s`)";
    // 字段完整格式
    public static final String COLUMN_LENGTH = "%s(%s)";
    // DECIMAL类型字段完整格式
    public static final String COLUMN_DECIMAL_LENGTH = "%s(%s,%s)";
    // 非空
    public static final String NOT_NULL = "NOT NULL ";
    private GraphMap graphMap;


    public MySqlTableSqlGenerator() {
        super();
    }
    public MySqlTableSqlGenerator(GraphMap graphMap) {
        this.graphMap = graphMap;
    }


    @Override
    public String generatorSql() {
        // TODO 数据库的引擎、编码类型等信息
        Map<String, GraphNode> entityMap = graphMap.getEntityMap();
        Map<String, List<GraphNode>> entity2FieldLinkMap = graphMap.getEntity2FieldLinkMap();
        StringBuilder sb = new StringBuilder();
        Iterator<Map.Entry<String, GraphNode>> iterator = entityMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, GraphNode> next = iterator.next();
            GraphNode tableNode = next.getValue();
            List<GraphNode> fieldNodes = entity2FieldLinkMap.get(next.getKey());
            sb.append(packageSql(tableNode,fieldNodes));
        }
        return sb.toString();
    }

    /**
     * 组装SQL
     * @param tableNode 表节点
     * @param fieldNodes 属性节点
     * @return
     */
    public String packageSql(GraphNode tableNode,List<GraphNode> fieldNodes){
        StringBuilder fieldSb = new StringBuilder();
        int size = fieldNodes.size();
        for(int i=0;i<size;i++){
            GraphNode fieldNode = fieldNodes.get(i);
            String  fieldSql = budilFieldSql(fieldNode.getName(),fieldNode.getFieldLength(),fieldNode.getFieldType(),
                    fieldNode.getDescription(),fieldNode.getPrimaryTag(),fieldNode.getAutoIncrementTag(),
                    fieldNode.getDecimalLength(),fieldNode.getNullTag(),fieldNode.getDefaultValue());
            if(i == size -1){
                fieldSb.append(fieldSql);
            }else{
                fieldSb.append(fieldSql+LINE_COMMA);
            }
        }
        return budilTableSql(tableNode.getName(), fieldSb.toString(), DEFAULT_CHARSET, DEFAULT_COLLATE, tableNode.getDescription());
    }

    /**
     * 组装表sql
     * @param tableName     表名称
     * @param fieldContent  字段内容
     * @param charsetType   表字符集编码
     * @param collateType   表字符集编码排序格式
     * @param tableComment  表注释
     * @return
     */
    public String budilTableSql(String tableName,String fieldContent,String charsetType,String collateType,String tableComment){
        if(charsetType == null || charsetType.isEmpty()){
            charsetType = DEFAULT_CHARSET;
        }
        if(collateType == null || collateType.isEmpty()){
            collateType = DEFAULT_COLLATE;
        }
        return String.format(CREATE_TABLE_FORMAT,tableName,fieldContent,charsetType,collateType,tableComment);
    }


    /**
     * 组装字段Sql
     * @param fieldName     字段名称
     * @param fieldLength   字段长度
     * @param fieldType     字段类型
     * @param comment       字段注释
     * @param primaryTag    是否为主键
     * @param autoIncrementTag  是否自增
     * @param decimalLength     小数部分长度
     * @param nullTag       是否为空
     * @param defaultValue  默认值
     * @return
     */
    public String budilFieldSql(String fieldName,Integer fieldLength,Integer fieldType,String comment,
                                 Integer primaryTag,Integer autoIncrementTag,Integer decimalLength,Integer nullTag,String defaultValue){

        IColumnType columnType = MysqlColumnType.getTypeByValue(fieldType);
        String type = columnType.getType();
        String filedTypeAll = (decimalLength != null && decimalLength >= 0)?String.format(COLUMN_DECIMAL_LENGTH,type,fieldLength,decimalLength):
                String.format(COLUMN_LENGTH,type,fieldLength);
        // 判断是否为主键
        if(1 == primaryTag){
            String primaryKey = String.format(PRIMARY_KEY,fieldName);
            String primaryKeySql = (1 == autoIncrementTag) ? String.format(FIELD_FORMAT,fieldName,filedTypeAll,NOT_NULL,AUTO_INCREMENT,comment,primaryKey):
                    String.format(FIELD_FORMAT,filedTypeAll,NOT_NULL,"",comment,primaryKey);
            return primaryKeySql;
        }else{
            String defaultField = 0==nullTag? String.format(FIELD_DEFAULT_VALUE,defaultValue):NOT_NULL;
            return String.format(FIELD_FORMAT,fieldName,filedTypeAll,defaultField,"",comment,"");
        }
    }







}
