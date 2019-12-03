package tesseract.captain.generator;

import tesseract.captain.generator.config.GlobalConfig;
import tesseract.captain.generator.language.ILanguageGenerator;
import tesseract.captain.server.model.dto.GraphDTO;

import java.util.List;

/**
 * 代码生成抽象类
 * @author: LeoLee
 * @date: 2019/12/3 09:55
 */
public abstract class AbstractCodeGenerator implements ICodeGenerator{

    @Override
    public void preGenerate(GraphDTO graph) {

    }

    @Override
    public void execute() {}

    @Override
    public void postGenerate() {

    }
}
