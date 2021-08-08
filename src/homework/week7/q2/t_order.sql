drop table if exists `t_order`;
create table t_order
(
    id          int(9) auto_increment comment '订单ID' primary key,
    user_id     int(9) NOT NULL comment '用户ID',
    amount int(9) not null comment '金额',
    status tinyint(1) not null default 0 comment '状态',
    create_time timestamp         null comment '创建时间',
    modify_time timestamp         null on update CURRENT_TIMESTAMP comment '更新时间',
    version     int(10) default 0 null
)
    comment '订单';
