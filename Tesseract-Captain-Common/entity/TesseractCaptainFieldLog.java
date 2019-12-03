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
@ApiModel(value="TesseractCaptainFieldLog对象", description="")
public class TesseractCaptainFieldLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "属性名")
    private String name;

    @ApiModelProperty(value = "实体ID")
    private Integer entityId;

    @ApiModelProperty(value = "实体名")
    private String entityName;

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
