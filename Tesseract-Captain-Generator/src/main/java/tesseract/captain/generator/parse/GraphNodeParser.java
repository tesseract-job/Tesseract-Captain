package tesseract.captain.generator.parse;

import tesseract.captain.common.constant.GlobalConstant;
import tesseract.captain.generator.exception.GeneratorException;
import tesseract.captain.generator.po.GraphMap;
import tesseract.captain.server.model.dto.GraphLink;
import tesseract.captain.server.model.dto.GraphNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 解析图节点
 * @author: LeoLee <zeroming@163.com>
 * @date: 2019/12/5 09:45
 */
public final  class GraphNodeParser {



    /**
     * 解析图节点
     * @param nodes 结点集合
     * @param links 关联集合
     * @return
     */
    public static GraphMap parseGraph(List<GraphNode> nodes, List<GraphLink> links) throws GeneratorException {

        /**
         * 1.1. 将所有的实体类型节点，以GraphNode的name作为key,GraphNode作为value，扔进entityMap中
         * 1.2. 所有属性节点扔到fieldMap中
         * 1.2. 遍历links,查出实体-实体类型（type=1）的关联关系，以source作为Map的key,GraphLink作为value。扔进entityLinkMap中。
         */
        Map<String,GraphNode> entityMap = new HashMap<>();
        Map<String,GraphNode> fieldMap = new HashMap<>();
        Map<String,GraphNode> operateMap = new HashMap<>();

        // 关联Map：key = 关联源结点, value=关联目标节点
        parseNode(nodes,entityMap,fieldMap,operateMap);

        // 结点之间关联: 1对多
        Map<String,List<GraphNode>> entity1V1LinkMap = new HashMap<>();
        Map<String,List<GraphNode>> entity1VNLinkMap = new HashMap<>();
        // 实体属性之间关联: 1对多
        Map<String,List<GraphNode>> entity2FieldLinkMap = new HashMap<>();
        // 实体->操作关联: 1对多
        Map<String,List<GraphNode>> entity2OperateLinkMap = new HashMap<>();
        // 操作->实体关联: 1对1
        Map<String,GraphNode> operate2EntityLinkMap = new HashMap<>();
        parseLink(links,entityMap,entity1V1LinkMap,entity1VNLinkMap,entity2FieldLinkMap,entity2OperateLinkMap,operate2EntityLinkMap);
        return new GraphMap.Builder()
                .entityMap(entityMap).fieldMap(fieldMap).operateMap(operateMap)
                .entity1V1LinkMap(entity1V1LinkMap).entity1VNLinkMap(entity1VNLinkMap)
                .entity2FieldLinkMap(entity2FieldLinkMap).entity2OperateLinkMap(entity2OperateLinkMap)
                .operate2EntityLinkMap(operate2EntityLinkMap).build();
    }

    /**
     * 将关联关系存入映射
     * @param links
     * @param entityMap
     * @param entity1V1LinkMap
     * @param entity1VNLinkMap
     * @param entity2FieldLinkMap
     * @param entity2OperateLinkMap
     * @param operate2EntityLinkMap
     */
    public static void parseLink( List<GraphLink> links,Map<String,GraphNode> entityMap,Map<String,List<GraphNode>> entity1V1LinkMap,Map<String,List<GraphNode>> entity1VNLinkMap,Map<String,
            List<GraphNode>> entity2FieldLinkMap,Map<String,List<GraphNode>> entity2OperateLinkMap,Map<String,GraphNode> operate2EntityLinkMap){
        for(GraphLink graphLink:links){
            Integer type = graphLink.getType();
            String source = graphLink.getSource();
            String target = graphLink.getTarget();
            GraphNode targetNode = entityMap.get(target);
            if(type == GlobalConstant.LINK_ENTITY_2_ENTITY){
                Integer relationType = graphLink.getRelationType();
                if(relationType == GlobalConstant.RELATION_1V1){
                    isExistedNode(entity1V1LinkMap,source,targetNode);
                }

                if(relationType == GlobalConstant.RELATION_1VN){
                    isExistedNode(entity1VNLinkMap,source,targetNode);
                }
            }

            if(type == GlobalConstant.LINK_ENTITY_2_FIELD){
                isExistedNode(entity2FieldLinkMap,source,targetNode);
            }

            if(type == GlobalConstant.LINK_ENTITY_2_OPERATE){
                isExistedNode(entity2OperateLinkMap,source,targetNode);
            }

            if(type == GlobalConstant.LINK_OPERATE_2_ENTITY){
                operate2EntityLinkMap.put(source,targetNode);
            }
        }

    }

    /**
     * 将结点放入映射中
     * @param nodes
     * @param entityMap
     * @param fieldMap
     * @param operateMap
     */
    public static void parseNode(List<GraphNode> nodes,Map<String,GraphNode> entityMap ,Map<String,GraphNode> fieldMap,Map<String,GraphNode> operateMap){
        for(GraphNode graphNode:nodes){
            Integer type = graphNode.getType();
            String name = graphNode.getName();
            if(type == GlobalConstant.NODE_TYPE_ENTITY || type == GlobalConstant.NODE_TYPE_MIDDLE_ENTITY){
                entityMap.put(name,graphNode);
            }
            if(type == GlobalConstant.NODE_TYPE_FIELD){
                fieldMap.put(name,graphNode);
            }
            if(type == GlobalConstant.NODE_TYPE_OPERATE){
                operateMap.put(name,graphNode);
            }
        }
    }


    public static  <T> void  isExistedNode(Map<String,List<T>> nodeMap,String source,T targetNode){
        List<T> nodeList = nodeMap.get(source);
        if(nodeList == null){
            nodeList = new ArrayList<>();
            nodeList.add(targetNode);
            nodeMap.put(source,nodeList);
        }else{
            nodeList.add(targetNode);
        }
    }


}
