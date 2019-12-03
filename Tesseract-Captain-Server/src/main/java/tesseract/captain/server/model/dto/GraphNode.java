package tesseract.captain.server.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 图实体节点
 * @author: LeoLee <zeroming@163.com>
 * @date: 2019/12/3 17:01
 */
@Data
@ApiModel(value = "图实体节点")
public class GraphNode implements Serializable {

    /**
     * 节点名称
     */
    @ApiModelProperty(value = "节点名称",name = "name",dataType = "string")
    private String name;
    /**
     * 节点描述
     */
    @ApiModelProperty(value = "节点描述",name = "description",dataType = "string")
    private String description;
    /**
     * 节点类型。1-实体节点;2-属性节点;3-操作节点;
     */
    @ApiModelProperty(value = "节点类型。1-实体节点;2-属性节点;3-操作节点;",name = "type",dataType = "int")
    private Integer type;

    /**
     * 字段节点数据类型.映射关系：1-int;2-varchar;...
     */
    @ApiModelProperty(value = "字段节点数据类型.映射关系：1-int;2-varchar;...",name = "fieldType",dataType = "int")
    private Integer fieldType;

    /**
     * 字段节点数据长度
     */
    @ApiModelProperty(value = "字段节点数据长度",name = "fieldLength",dataType = "int")
    private Integer fieldLength;




}
