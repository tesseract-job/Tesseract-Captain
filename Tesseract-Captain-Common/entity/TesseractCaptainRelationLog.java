package tesseract.captain.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author nickle
 * @since 2019-12-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TesseractCaptainRelationLog对象", description="")
public class TesseractCaptainRelationLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "主实体ID")
    private Integer fromEntityId;

    @ApiModelProperty(value = "主实体名")
    private String fromEntityName;

    @ApiModelProperty(value = "从实体ID")
    private Integer toEntityId;

    @ApiModelProperty(value = "从实体名")
    private String toEntityName;

    @ApiModelProperty(value = "关系名")
    private String relationName;

    @ApiModelProperty(value = "负责人id")
    private String leaderId;

    @ApiModelProperty(value = "负责人名字")
    private String leaderName;

    @ApiModelProperty(value = "产品id")
    private Integer productId;

    @ApiModelProperty(value = "产品名")
    private String productName;

    @ApiModelProperty(value = "创建者")
    private String creator;

    @ApiModelProperty(value = "创建时间")
    private Long createTime;


}
