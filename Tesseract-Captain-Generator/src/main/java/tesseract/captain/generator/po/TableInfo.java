package tesseract.captain.generator.po;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 代码模板对应的表实体信息
 * @author: LeoLee <zeroming@163.com>
 * @date: 2019/12/4 14:59
 */
@Setter
@Getter
public class TableInfo {
    /**
     * 需要导入的包依赖
     */
    private final Set<String> importPackages = new HashSet();
    private boolean convert;
    private String name;
    private String comment;
    private String entityName;
    private String mapperName;
    private String xmlName;
    private String serviceName;
    private String serviceImplName;
    private String controllerName;
    private List<TableField> fields;


}
