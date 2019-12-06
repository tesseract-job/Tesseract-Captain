package tesseract.captain.generator.po;

import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import lombok.Getter;
import lombok.Setter;

/**
 * 代码模板对应的表字段属性信息
 * @author: LeoLee <zeroming@163.com>
 * @date: 2019/12/4 15:01
 */
@Setter
@Getter
public class TableField {
    private boolean keyFlag;
    private boolean keyIdentityFlag;
    private String name;
    private String type;
    private String propertyName;
    private IColumnType columnType;
    private String comment;
}
