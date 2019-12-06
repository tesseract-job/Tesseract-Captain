package tesseract.captain.generator.db.sql;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import tesseract.captain.server.model.dto.GraphNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Mysql建表语句生成器
 * @author: LeoLee <zeroming@163.com>
 * @date: 2019/12/6 10:04
 */
public class MySqlTableSqlGeneratorTest {

    MySqlTableSqlGenerator mySqlTableSqlGenerator;
    GraphNode tableNode;
    List<GraphNode> fieldNodes;

    @BeforeClass
    public static void setup() {
    }

    @Before
    public void setup_1() {
        mySqlTableSqlGenerator = new MySqlTableSqlGenerator();
        tableNode = new GraphNode();
        tableNode.setName("测试");
        tableNode.setDescription("测试注释");

        fieldNodes = new ArrayList<>();
        GraphNode graphNode1 = new GraphNode();
        graphNode1.setName("id");
        graphNode1.setFieldType(5);
        graphNode1.setDescription("描述1");
        graphNode1.setAutoIncrementTag(1);
        graphNode1.setPrimaryTag(1);
        graphNode1.setNullTag(1);
        graphNode1.setFieldLength(11);
        fieldNodes.add(graphNode1);

        // 2
        GraphNode graphNode2 = new GraphNode();
        graphNode2.setName("name");
        graphNode2.setFieldType(21);
        graphNode2.setDescription("描述1");
        graphNode2.setAutoIncrementTag(0);
        graphNode2.setPrimaryTag(0);
        graphNode2.setNullTag(1);
        graphNode2.setFieldLength(55);
        fieldNodes.add(graphNode2);


        // 3
        GraphNode graphNode3 = new GraphNode();
        graphNode3.setName("content");
        graphNode3.setFieldType(23);
        graphNode3.setDescription("描述1");
        graphNode3.setAutoIncrementTag(0);
        graphNode3.setPrimaryTag(0);
        graphNode3.setNullTag(1);
        graphNode3.setFieldLength(0);
        fieldNodes.add(graphNode3);

    }


    @After
    public void tearDown() throws Exception {
        tableNode = null;
        fieldNodes = null;
    }

    @Test
    public void packageSql() {
        String sql = mySqlTableSqlGenerator.packageSql(tableNode, fieldNodes);
        System.out.println(sql);
    }

}