package tesseract.captain.generator.db;

import tesseract.captain.generator.config.CodeConfigBuilder;
import tesseract.captain.generator.config.SQLConfigBuilder;
import tesseract.captain.generator.exception.GeneratorException;
import tesseract.captain.generator.parse.GraphNodeParser;
import tesseract.captain.generator.po.GraphMap;
import tesseract.captain.server.model.dto.GraphDTO;
import tesseract.captain.server.model.dto.GraphLink;
import tesseract.captain.server.model.dto.GraphNode;

import java.util.List;
import java.util.Map;

/**
 *
 * @author: LeoLee <zeroming@163.com>
 * @date: 2019/12/4 09:22
 */
public abstract class AbstractTableGenerator implements ITableGenerator{

    private SQLConfigBuilder sqlConfigBuilder;
    private GraphMap graphMap;
    private Boolean flag = false;

    @Override
    public Boolean generateSQL(GraphDTO graph) throws GeneratorException {
        preGenerateSQL(graph);
        flag = doExecuteSQL(graphMap,sqlConfigBuilder);
        postGenerateSQL();
        return flag;
    }

    @Override
    public void preGenerateSQL(GraphDTO graph) throws GeneratorException {
        List<GraphNode> nodes = graph.getNodes();
        List<GraphLink> links = graph.getLinks();
        graphMap = GraphNodeParser.parseGraph(nodes, links);
    }

    @Override
    public Boolean doExecuteSQL(GraphMap graphMap, SQLConfigBuilder sqlConfigBuilder) {return false;}

    @Override
    public void postGenerateSQL() {

    }
}
