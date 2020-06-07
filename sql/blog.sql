# pwd: DONGhuye@123
create table blog_user
(
    user_id         bigint                                not null comment '主键id'
        primary key,
    nick            varchar(20)                           not null comment '用户昵称',
    real_name       varchar(20) default ''                not null comment '真实姓名',
    email           varchar(30)                           not null comment '用户邮箱',
    phone           varchar(64)                           not null comment '用户电话',
    role            int         default 0                 not null comment '用户角色',
    create_time     timestamp   default CURRENT_TIMESTAMP not null comment '创建时间',
    is_invite       tinyint(1)  default 0                 not null comment '是否邀请用户',
    update_time     timestamp   default CURRENT_TIMESTAMP not null comment '最后修改时间',
    update_operator bigint      default 0                 not null comment '修改人',
    data_flag       tinyint(1)  default 1                 not null comment ' 是否有效',
    constraint blog_user_nick_uindex
        unique (nick),
    constraint blog_user_user_email_IDX
        unique (email),
    constraint blog_user_user_phone_IDX
        unique (phone)
)
    comment '用户表';

create table blog_article
(
    article_id  bigint auto_increment comment '文章主键'
        primary key,
    title       varchar(20)                            not null comment '标题',
    summary     varchar(100) default ''                null comment '提要',
    content     text                                   not null comment '文章内容',
    type        int          default 0                 not null comment '文章类型 关联字典表',
    create_time timestamp    default CURRENT_TIMESTAMP not null comment '更新时间',
    update_time timestamp    default CURRENT_TIMESTAMP null comment '创建时间',
    author      varchar(20)                            not null comment '作者',
    read_count  bigint       default 0                 not null comment '阅读数量',
    data_flag   tinyint      default 1                 not null,
    top_flag    tinyint      default 0                 null comment '置顶标识0否1是'
)
    comment '文章表';


create table blog.blog_comment
(
    comment_id   bigint auto_increment comment '主键'
        primary key,
    article_id   bigint                             not null comment '关联文章id',
    reply_id     bigint                             null comment '回复id',
    content      varchar(200)                       not null comment '评论内容',
    commenter    bigint   default 0                 not null comment '评论用户id',
    comment_time datetime default CURRENT_TIMESTAMP not null comment '评论时间',
    like_count   int      default 0                 not null comment '点赞数',
    data_flag    tinyint  default 1                 not null comment '数据状态',
)
    comment '评论表';


create table blog_dict
(
    dict_id int auto_increment,
    dict_code varchar(20) not null comment '字典编码',
    dict_name varchar(20) not null comment '字典名称',
    data_flag TINYINT(2) default 1 null,
    constraint blog_dict_pk
        primary key (dict_id)
);

create unique index blog_dict_dict_code_uindex
    on blog_dict (dict_code);


create table blog_dict_item
(
    dict_item_id int auto_increment
        primary key,
    dict_id      int         not null comment '字典表id',
    item_value   tinyint     not null comment '字典取值',
    item_name    varchar(20) not null comment '字典说明',
    item_order   tinyint     null comment '可选-字典排序',
    data_flag    tinyint(2)  null comment '1'
)
    comment '字典选项表';



