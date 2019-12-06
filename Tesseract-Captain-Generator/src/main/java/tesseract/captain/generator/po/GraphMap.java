package tesseract.captain.generator.po;

import lombok.Getter;
import tesseract.captain.server.model.dto.GraphNode;

import java.util.List;
import java.util.Map;

/**
 * 图节点映射
 * 方便后续解析与生成SQL
 * @author: LeoLee <zeroming@163.com>
 * @date: 2019/12/5 09:51
 */
@Getter
public class GraphMap {
    /**
     * 实体映射
     */
    private Map<String,GraphNode> entityMap;
    /**
     * 属性映射
     */
    private Map<String,GraphNode> fieldMap;
    /**
     * 操作映射
     */
    private Map<String,GraphNode> operateMap;
    /**
     * 中间表映射
     */
    private Map<String,GraphNode>  middleEntityMap;
    /**
     * 1v1 结点关联的映射
     */
    private Map<String, List<GraphNode>> entity1V1LinkMap;
    /**
     * 1vN 结点关联的映射
     */
    private Map<String,List<GraphNode>> entity1VNLinkMap;

    /**
     * 实体->属性 映射
     */
    private  Map<String,List<GraphNode>> entity2FieldLinkMap;
    /**
     * 实体->操作 映射
     */
    private Map<String,List<GraphNode>> entity2OperateLinkMap;
    /**
     * 操作->实体 映射
     */
    private Map<String,GraphNode> operate2EntityLinkMap;
    /**
     * 实体->主键 映射
     */
    @Deprecated
    private Map<String,GraphNode> entity2PrimaryKeymap;

    private GraphMap(Builder builder){
        this.entityMap = builder.entityMap;
        this.fieldMap = builder.fieldMap;
        this.operateMap = builder.operateMap;
        this.entity1V1LinkMap = builder.entity1V1LinkMap;
        this.entity1VNLinkMap = builder.entity1VNLinkMap;
        this.middleEntityMap = builder.middleEntityMap;
        this.entity2FieldLinkMap = builder.entity2FieldLinkMap;
        this.entity2OperateLinkMap = builder.entity2OperateLinkMap;
        this.operate2EntityLinkMap = builder.operate2EntityLinkMap;
        this.entity2PrimaryKeymap = builder.entity2PrimaryKeymap;
    }

    public static class Builder{

        private Map<String,GraphNode> entityMap;
        private Map<String,GraphNode> fieldMap;
        private Map<String,GraphNode> operateMap;
        private Map<String,GraphNode> middleEntityMap;
        private Map<String, List<GraphNode>> entity1V1LinkMap;
        private Map<String,List<GraphNode>> entity1VNLinkMap;
        private Map<String,List<GraphNode>> entity2FieldLinkMap;
        private Map<String,List<GraphNode>> entity2OperateLinkMap;
        private Map<String,GraphNode> operate2EntityLinkMap;
        private Map<String,GraphNode> entity2PrimaryKeymap;

        public Builder entityMap(Map<String,GraphNode> fieldMap){
            this.entityMap = entityMap;
            return this;
        }

        public Builder fieldMap(Map<String,GraphNode> fieldMap){
            this.fieldMap = fieldMap;
            return this;
        }

        public Builder operateMap(Map<String,GraphNode> operateMap){
            this.operateMap = operateMap;
            return this;
        }

        public Builder entity1V1LinkMap(Map<String, List<GraphNode>> entity1V1LinkMap){
            this.entity1V1LinkMap = entity1V1LinkMap;
            return this;
        }

        public Builder entity1VNLinkMap(Map<String,List<GraphNode>> entity1VNLinkMap){
            this.entity1VNLinkMap = entity1VNLinkMap;
            return this;
        }

        public Builder middleEntityMap(Map<String,GraphNode> middleEntityMap){
            this.middleEntityMap = middleEntityMap;
            return this;
        }

        public Builder entity2FieldLinkMap(Map<String,List<GraphNode>> entity2FieldLinkMap){
            this.entity2FieldLinkMap = entity2FieldLinkMap;
            return this;
        }

        public Builder entity2OperateLinkMap(Map<String,List<GraphNode>> entity2OperateLinkMap){
            this.entity2OperateLinkMap = entity2OperateLinkMap;
            return this;
        }
        public Builder operate2EntityLinkMap(Map<String,GraphNode> operate2EntityLinkMap){
            this.operate2EntityLinkMap = operate2EntityLinkMap;
            return this;
        }

        public Builder entity2PrimaryKeymap(Map<String,GraphNode> entity2PrimaryKeymap){
            this.entity2PrimaryKeymap = entity2PrimaryKeymap;
            return this;
        }

        // return MyConstractor
        public GraphMap build(){
            return new GraphMap(this);
        }
    }

}
