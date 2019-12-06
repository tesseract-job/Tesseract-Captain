package tesseract.captain.generator.template;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import tesseract.captain.generator.config.CodeConfigBuilder;

import java.io.*;
import java.util.Map;

/**
 * Freemarker 模板生成引擎
 * @author: LeoLee <zeroming@163.com>
 * @date: 2019/12/3 18:29
 */
public class FreemarkerTemplateEngine extends AbstractTemplateEngine{

    @Override
    public FreemarkerTemplateEngine init(CodeConfigBuilder configBuilder) {
        super.init(configBuilder);
        return this;
    }


    @Override
    public void writer(Map<String, Object> objectMap, String templatePath, String outputFile) throws IOException, TemplateException {
        Template template = super.getGeneratorConfigBuilder().getTemplate();
        FileOutputStream fos = null;
        BufferedWriter writer = null;
        try{
            fos = new FileOutputStream(outputFile);
            writer = new BufferedWriter(new OutputStreamWriter(fos, "UTF-8"));
            template.process(objectMap, writer);
        }finally {
            if(fos != null){
                fos.close();
            }
            if(writer != null){
                writer.close();
            }
        }
    }

}
