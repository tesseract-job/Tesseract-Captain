package tesseract.captain.generator.parse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import tesseract.captain.generator.db.sql.MySqlTableSqlGenerator;
import tesseract.captain.generator.exception.GeneratorException;
import tesseract.captain.generator.po.GraphMap;
import tesseract.captain.server.model.dto.GraphDTO;
import tesseract.captain.server.model.dto.GraphLink;
import tesseract.captain.server.model.dto.GraphNode;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 *
 * @author: LeoLee <zeroming@163.com>
 * @date: 2019/12/6 10:59
 */
public class GraphNodeParserTest {

    GraphDTO graphDTO;

    @Before
    public void setup_1() {
        graphDTO = new GraphDTO();
    }


    @After
    public void tearDown() throws Exception {
        graphDTO = null;

    }

    @Test
    public void parseGraph() throws GeneratorException {
        List<GraphLink> links = graphDTO.getLinks();
        List<GraphNode> nodes = graphDTO.getNodes();
        GraphMap graphMap = GraphNodeParser.parseGraph(nodes, links);
        System.out.println(graphMap);
    }

}