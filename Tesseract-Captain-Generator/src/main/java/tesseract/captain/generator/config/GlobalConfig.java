package tesseract.captain.generator.config;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 代码生成全局配置
 * @author: LeoLee <zeroming@163.com>
 * @date: 2019/12/3 10:03
 */
@Data
public class GlobalConfig {

    private Integer languageType;
    private String  outputDir = "D://";
    private boolean fileOverride = false;
    private String author;
    private boolean swagger2 = false;
    private boolean activeRecord = false;
    private boolean baseResultMap = false;
    private boolean baseColumnList;
    private String entityName;
    private String mapperName;
    private String xmlName;
    private String serviceName;
    private String serviceImplName;
    private String controllerName;
    private IdType idType;

}
