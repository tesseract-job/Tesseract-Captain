CREATE DATABASE if NOT EXISTS `tesseract_captain` default character set utf8 collate utf8_general_ci;
use `tesseract_captain`;

create table tesseract_captain_product
(
    id          int unsigned auto_increment primary key,
    name        varchar(20) not null comment '产品名',
    leader_id   varchar(20) not null comment '负责人id',
    leader_name varchar(20) not null comment '负责人名字',
    creator     varchar(20) not null comment '创建者',
    create_time bigint      not null comment '创建时间',
    update_time bigint      not null comment '更新时间',
    description varchar(255) comment '描述'
);

create table tesseract_captain_user
(
    id           int unsigned auto_increment primary key,
    name         varchar(20)  not null comment '用户名',
    password     varchar(255) not null comment '用户密码',
    creator      varchar(20)  not null comment '创建者',
    create_time  bigint       not null comment '创建时间',
    update_time  bigint       not null comment '更新时间',
    description  varchar(255) comment '描述',
    product_id   int unsigned not null comment '所属产品id',
    product_name varchar(20)  not null comment '所属产品名字'
);

create table tesseract_captain_entity
(
    id           int unsigned auto_increment primary key,
    name         varchar(20)  not null comment '实体名',
    creator      varchar(20)  not null comment '创建者',
    create_time  bigint       not null comment '创建时间',
    update_time  bigint       not null comment '更新时间',
    description  varchar(255) comment '描述',
    product_id   int unsigned not null comment '所属产品id',
    product_name varchar(20)  not null comment '所属产品名字'
);

create table tesseract_captain_field
(
    id           int unsigned auto_increment primary key,
    entity_id    int unsigned not null comment '所属实体ID',
    name         varchar(20)  not null comment '属性名',
    type         tinyint      not null comment '属性类型: int,string等',
    creator      varchar(20)  not null comment '创建者',
    create_time  bigint       not null comment '创建时间',
    update_time  bigint       not null comment '更新时间',
    description  varchar(255) comment '描述',
    product_id   int unsigned not null comment '所属产品id',
    product_name varchar(20)  not null comment '所属产品名字'
);


create table tesseract_captain_entity_method_relation
(
    id               int unsigned auto_increment primary key,
    from_entity_id   int unsigned not null comment '主实体ID',
    from_entity_name varchar(20)  not null comment '主实体名',
    to_entity_id     int unsigned not null comment '从实体ID',
    to_entity_name   varchar(20)  not null comment '从实体名',
    name             varchar(20)  not null comment '关系名',
    creator          varchar(20)  not null comment '创建者',
    create_time      bigint       not null comment '创建时间',
    update_time      bigint       not null comment '更新时间',
    description      varchar(255) comment '描述',
    return_type      tinyint      not null comment '返回参数类型,映射后期补充',
    product_id       int unsigned not null comment '所属产品id',
    product_name     varchar(20)  not null comment '所属产品名字'
);

create table tesseract_captain_entity_method_arg
(
    id                        int unsigned auto_increment primary key,
    entity_method_relation_id int unsigned not null comment '所属关系ID',
    name                      varchar(20)  not null comment '参数名',
    type                      tinyint      not null comment '参数类型,映射后期补充',
    create_time               bigint       not null comment '创建时间',
    update_time               bigint       not null comment '更新时间'
);

create table tesseract_captain_entity_relation
(
    id               int unsigned auto_increment primary key,
    from_entity_id   int          not null comment '主实体ID',
    from_entity_name varchar(20)  not null comment '主实体名',
    to_entity_id     int unsigned not null comment '从实体ID',
    to_entity_name   varchar(20)  not null comment '从实体名',
    type             tinyint      not null comment '关系类型:一对多，一对一，多对多',
    creator          varchar(20)  not null comment '创建者',
    create_time      bigint       not null comment '创建时间',
    update_time      bigint       not null comment '更新时间',
    description      varchar(255) comment '描述',
    product_id       int unsigned not null comment '所属产品id',
    product_name     varchar(20)  not null comment '所属产品名字'
);



create table tesseract_captain_field_log
(
    id           bigint unsigned auto_increment primary key,
    name         varchar(20)  not null comment '属性名',
    entity_id    int unsigned not null comment '实体ID',
    entity_name  varchar(20)  not null comment '实体名',
    leader_id    varchar(20)  not null comment '负责人id',
    leader_name  varchar(20)  not null comment '负责人名字',
    product_id   int unsigned not null comment '产品id',
    product_name varchar(20)  not null comment '产品名',
    creator      varchar(20)  not null comment '创建者',
    create_time  bigint       not null comment '创建时间'
);

create table tesseract_captain_relation_log
(
    id               bigint unsigned auto_increment primary key,
    from_entity_id   int          not null comment '主实体ID',
    from_entity_name varchar(20)  not null comment '主实体名',
    to_entity_id     int unsigned not null comment '从实体ID',
    to_entity_name   varchar(20)  not null comment '从实体名',
    relation_name    varchar(20)  not null comment '关系名',
    leader_id        varchar(20)  not null comment '负责人id',
    leader_name      varchar(20)  not null comment '负责人名字',
    product_id       int unsigned not null comment '产品id',
    product_name     varchar(20)  not null comment '产品名',
    creator          varchar(20)  not null comment '创建者',
    create_time      bigint       not null comment '创建时间'
);