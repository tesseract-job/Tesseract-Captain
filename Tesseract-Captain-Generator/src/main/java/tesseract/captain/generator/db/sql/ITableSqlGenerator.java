package tesseract.captain.generator.db.sql;

/**
 * @author: LeoLee <zeroming@163.com>
 * @date: 2019/12/5 09:40
 */
public interface ITableSqlGenerator {

    String generatorSql();

    /**
     * CREATE TABLE `classin_relevance` (
     *   `id` int(11) NOT NULL AUTO_INCREMENT,
     *   `classin_mobile` varchar(11) CHARACTER SET utf8 DEFAULT NULL COMMENT 'classIn账号',
     *   `classIin_password` varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT 'classin账户密码',
     *   `user_id` int(11) DEFAULT NULL COMMENT '关联学生/教师id',
     *   `user_type` int(2) DEFAULT NULL COMMENT '用户类型 1 学生 2 教师',
     *   `is_used` int(2) DEFAULT '0' COMMENT '是否被使用',
     *   `source` int(2) DEFAULT '1' COMMENT '数据来源：1在线，2青龙',
     *   `content` text COLLATE utf8mb4_unicode_ci,
     *   PRIMARY KEY (`id`),
     *   KEY `idx_user_id` (`user_id`) USING BTREE
     * ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
     */





}
