package tesseract.captain.generator.db;

import tesseract.captain.generator.config.SQLConfigBuilder;
import tesseract.captain.generator.exception.GeneratorException;
import tesseract.captain.generator.po.GraphMap;
import tesseract.captain.server.model.dto.GraphDTO;

import java.util.List;
import java.util.Map;

/**
 * 表结构生成器接口
 * @author: LeoLee <zeroming@163.com>
 * @date: 2019/12/4 09:21
 */
public interface ITableGenerator {
    /**
     * 代码生成入口
     */
    Boolean generateSQL(GraphDTO graph) throws GeneratorException;

    /**
     * 代码生成前置校验
     * @param graph
     */
    void preGenerateSQL(GraphDTO graph) throws GeneratorException;

    /**
     * 执行代码生成
     */
    Boolean doExecuteSQL(GraphMap graphMap, SQLConfigBuilder sqlConfigBuilder);

    String parseSQL(GraphMap graphMap);

    /**
     * 代码生成后置处理
     */
    void postGenerateSQL();

}
