package tesseract.captain.generator.config;

import freemarker.template.Template;
import lombok.Data;

import java.util.Map;

/**
 * @author: LeoLee <zeroming@163.com>
 * @date: 2019/12/3 18:04
 */
@Data
public final class CodeConfigBuilder {

    private GlobalConfig globalConfig;
    public  Template template;


}
