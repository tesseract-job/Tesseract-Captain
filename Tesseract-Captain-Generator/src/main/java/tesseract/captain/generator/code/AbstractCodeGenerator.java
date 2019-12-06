package tesseract.captain.generator.code;

import lombok.Getter;
import lombok.Setter;
import org.checkerframework.checker.units.qual.C;
import tesseract.captain.generator.config.CodeConfigBuilder;
import tesseract.captain.generator.exception.GeneratorException;
import tesseract.captain.generator.parse.GraphNodeParser;
import tesseract.captain.generator.po.GraphMap;
import tesseract.captain.server.model.dto.GraphDTO;
import tesseract.captain.server.model.dto.GraphLink;
import tesseract.captain.server.model.dto.GraphNode;

import java.util.List;
import java.util.Map;

/**
 * 代码生成抽象类
 * @author: LeoLee
 * @date: 2019/12/3 09:55
 */
@Setter
@Getter
public abstract class AbstractCodeGenerator implements ICodeGenerator {

    private CodeConfigBuilder codeConfigBuilder;
    private GraphMap graphMap;
    private String generatorPath;

    @Override
    public String generate(GraphDTO graph) throws GeneratorException {
        preGenerate(graph);
        generatorPath = doExecute(graphMap,codeConfigBuilder);
        postGenerate();
        return generatorPath;
    }

    @Override
    public void preGenerate(GraphDTO graph) throws GeneratorException {
        // TODO 配置解析
        // CodeConfigBuilder codeConfigBuilder = ????

        // TODO 节点解析
        List<GraphNode> nodes = graph.getNodes();
        List<GraphLink> links = graph.getLinks();
        graphMap = GraphNodeParser.parseGraph(nodes, links);
    }

    @Override
    public void postGenerate() {

    }

    @Override
    public String doExecute(GraphMap graphMap, CodeConfigBuilder codeConfigBuilder) {return null;}
}
