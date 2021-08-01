
-- 6.（必做）基于电商交易场景（用户、商品、订单），设计一套简单的表结构，提交 DDL 的 SQL 文件到 Github（后面 2 周的作业依然要是用到这个表结构）。

drop table if exists `t_user`;
create table t_user
(
    id          int(9) auto_increment comment '用户ID' primary key,
    username        varchar(20)       not null comment '用户名',
    password      varchar(20)       null comment '密码',
    nickname        varchar(20)       null comment '昵称',
    idcard      varchar(30)     null comment '身份证',
    create_time timestamp         null comment '创建时间',
    modify_time timestamp         null on update CURRENT_TIMESTAMP comment '更新时间',
    version     int(10) default 0 null
)
    comment '用户';

drop table if exists `t_product`;
create table t_product
(
    id          int(9) auto_increment comment '编码' primary key,
    name        varchar(20)       not null comment '名称',
    type      varchar(20)       null comment '分类',
    weight        int(9)       null comment '重量',
    sales_price int(9) not null default 0 comment '优惠价',
    total_price int(9) not null default 0 comment '总价',
    supplier_id int(9) null comment '供应商编码',
    create_time timestamp         null comment '创建时间',
    modify_time timestamp         null on update CURRENT_TIMESTAMP comment '更新时间',
    version     int(10) default 0 null
)
    comment '商品';

drop table if exists `t_supplier`;
create table t_supplier
(
    id          int(9) auto_increment comment '编码' primary key,
    name        varchar(20)       not null comment '名称',
    code      varchar(20)       null comment '注册号',
    contact        int(9)       null comment '联系人',
    create_time timestamp         null comment '创建时间',
    modify_time timestamp         null on update CURRENT_TIMESTAMP comment '更新时间',
    version     int(10) default 0 null
)
    comment '供应商';

drop table if exists `t_shopping_cart`;
create table t_shopping_cart
(
    id          int(9) auto_increment comment '购物车ID' primary key,
    user_id     int(9) not null comment '用户ID',
    sales_price int(9) not null default 0 comment '优惠价',
    total_price int(9) not null default 0 comment '总价',
    create_time timestamp         null comment '创建时间',
    modify_time timestamp         null on update CURRENT_TIMESTAMP comment '更新时间',
    version     int(10) default 0 null
)
    comment '购物车';

drop table if exists `t_shopping`;
create table t_shopping
(
    id          int(9) auto_increment comment '编码' primary key,
    shopping_cart_id int(9) not null comment '购物车ID',
    product_id int(9) not null comment '商品ID',
    create_time timestamp         null comment '创建时间',
    modify_time timestamp         null on update CURRENT_TIMESTAMP comment '更新时间',
    version     int(10) default 0 null
)
    comment '购物车选购';

drop table if exists `t_order`;
create table t_order
(
    id          int(9) auto_increment comment '订单ID' primary key,
    user_id     int(9) not null comment '用户ID',
    amount int(9) not null comment '金额',
    sales_price int(9) not null default 0 comment '优惠价',
    total_price int(9) not null default 0 comment '总价',
    status tinyint(1) not null default 0 comment '状态',
    create_time timestamp         null comment '创建时间',
    modify_time timestamp         null on update CURRENT_TIMESTAMP comment '更新时间',
    version     int(10) default 0 null
)
    comment '订单';
drop table if exists `t_order_detail`;
create table t_order_detail
(
    id          int(9) auto_increment comment 'ID' primary key,
    order_id     int(9) not null comment '订单ID',
    user_id     int(9) not null comment '用户ID',
    product_id int(9) not null comment '商品ID',
    sales_price int(9) not null default 0 comment '优惠价',
    total_price int(9) not null default 0 comment '总价',
    status tinyint(1) not null default 0 comment '状态',
    create_time timestamp         null comment '创建时间',
    modify_time timestamp         null on update CURRENT_TIMESTAMP comment '更新时间',
    version     int(10) default 0 null
)
    comment '订单明细';





