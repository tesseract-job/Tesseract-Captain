package tesseract.captain.generator.template;

import freemarker.template.TemplateException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import tesseract.captain.generator.config.CodeConfigBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 生成代码模板引擎抽象类
 * @author: LeoLee <zeroming@163.com>
 * @date: 2019/12/3 12:08
 */
@Data
@Slf4j
public abstract class AbstractTemplateEngine {

    private CodeConfigBuilder generatorConfigBuilder;

    public AbstractTemplateEngine init(CodeConfigBuilder configBuilder) {
        this.generatorConfigBuilder = configBuilder;
        return this;
    }


    public AbstractTemplateEngine output() throws IOException, TemplateException {

        // TODO 解析配置转为Map<String,Object>。依次生成转换为Entity、Mapper、Dao、Service、Controller
        Map<String,Object> objectMap = new HashMap<>();
        writer(objectMap,"","");
        return this;
    }

    public  abstract void writer(Map<String, Object> objectMap, String templatePath, String outputFile) throws IOException, TemplateException;




}
