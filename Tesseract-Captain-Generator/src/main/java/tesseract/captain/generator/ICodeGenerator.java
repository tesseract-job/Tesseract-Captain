package tesseract.captain.generator;

import tesseract.captain.server.model.dto.GraphDTO;

import java.util.List;

/**
 * 代码生成接口
 * @author: LeoLee <zeroming@163.com>
 * @date: 2019/12/3 09:54
 */
public interface ICodeGenerator {
    /**
     * 代码生成入口
     */
    void generate(GraphDTO graph);

    /**
     * 代码生成前置校验
     * @param graph
     */
    void preGenerate(GraphDTO graph);

    /**
     * 执行代码生成
     */
    void execute();

    /**
     * 代码生成后置处理
     */
    void postGenerate();
}
