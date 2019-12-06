package tesseract.captain.server.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 图信息实体
 * @author: LeoLee <zeroming@163.com>
 * @date: 2019/12/3 17:24
 */
@Data
@ApiModel(value = "图信息实体")
public class GraphDTO implements Serializable {

    // TODO 可以定义其他的用户属性、相关的生成器的可配置属性

    /**
     * 代码基础包路径。如:com.tesseract
     */
    @ApiModelProperty(value = "代码基础包路径",name = "parentPackage",dataType = "string")
    private String parentPackage;

    @ApiModelProperty(value = "生成编程语言类型",name = "languageType",dataType = "int")
    private int languageType;

    @ApiModelProperty(value = "数据库类型",name = "DBType",dataType = "int")
    private int DBType;

    /**
     * 图节点集合
     */
    @ApiModelProperty(value = "图节点集合",name = "nodes",dataType = "list")
    private List<GraphNode> nodes;
    /**
     * 关系集合
     */
    @ApiModelProperty(value = "关系集合",name = "links",dataType = "list")
    private List<GraphLink> links;
}
