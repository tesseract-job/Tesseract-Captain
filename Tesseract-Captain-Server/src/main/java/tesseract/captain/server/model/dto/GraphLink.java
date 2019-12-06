package tesseract.captain.server.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 图关联关系
 * @author: LeoLee <zeroming@163.com>
 * @date: 2019/12/3 17:04
 */
@Data
@ApiModel(value = "图关联关系")
public class GraphLink implements Serializable {
    /**
     * 源节点
     */
    @ApiModelProperty(value = "源节点",name = "source",dataType = "string")
    private String source;
    /**
     * 目标节点
     */
    @ApiModelProperty(value = "目标节点",name = "target",dataType = "string")
    private String target;
    /**
     * 关联类型。1:实体->实体关联;2:实体->属性关联;3:实体->操作关联;4:操作->关联
     */
    @ApiModelProperty(value = "关联类型。1:实体-实体关联;2:实体-属性关联;3:实体-操作连接",name = "type",dataType = "int")
    private Integer type;
    /**
     * 实体关联类型。1-1v1;2-1vN;
     */
    @ApiModelProperty(value = "实体关联类型。1-1v1;2-1vN;",name = "relationType",dataType = "int")
    private Integer relationType;
}
