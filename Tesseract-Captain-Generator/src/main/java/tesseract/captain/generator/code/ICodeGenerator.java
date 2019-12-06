package tesseract.captain.generator.code;

import tesseract.captain.generator.config.CodeConfigBuilder;
import tesseract.captain.generator.exception.GeneratorException;
import tesseract.captain.generator.po.GraphMap;
import tesseract.captain.server.model.dto.GraphDTO;

import java.util.List;
import java.util.Map;

/**
 * 代码生成接口
 * @author: LeoLee <zeroming@163.com>
 * @date: 2019/12/3 09:54
 */
public interface ICodeGenerator {
    /**
     * 代码生成入口
     * @param graph
     * @return
     */
    String generate(GraphDTO graph) throws GeneratorException;

    /**
     * 代码生成前置校验
     * @param graph
     */
    void preGenerate(GraphDTO graph) throws GeneratorException;

    /**
     * 执行代码生成
     * @param graphMap
     * @param codeConfigBuilder
     * @return 返回压缩包地址
     */
    String doExecute(GraphMap graphMap, CodeConfigBuilder codeConfigBuilder);

    /**
     * 代码生成后置处理
     */
    void postGenerate();
}
