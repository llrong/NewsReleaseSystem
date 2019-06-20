create database graduation;
use  graduation;
drop table if exists User;
create table User(
	id int(11)  PRIMARY KEY auto_increment,
	userName varchar(20) not null comment'用户名称',
	password varchar(20) not null ,
	email varchar(20) not null unique  comment'邮箱',
   remark varchar(100) comment'备注',
	jusis  int(11) not null default'0' comment'用户所属权限分类,0表示普通用户，1表示管理员'
)ENGINE=InnoDB DEFAULT CHARSET=utf8 comment'用户表'


drop table if exists NewsType;
create table NewsType(
	id int(11)  PRIMARY KEY auto_increment,
	typeName varchar(20) not null unique COMMENT '新闻类型名称'
)ENGINE=InnoDB DEFAULT CHARSET=utf8 comment'新闻类型'


drop table if exists NewsInfo;
create table NewsInfo(
	id int(11)  PRIMARY KEY auto_increment,
	title varchar(100) not null  comment'新闻标题',
	content text not null comment'新闻内容',
	author varchar(20) not null,
	digest varchar(200) comment'摘要',
	typeId int(11) not null comment'所属新闻类型',
	isCheck tinyint(4) default '0' comment'0表示未审核，1表示已经审核',
	picture varchar(200) comment'新闻图片路径',
	hits int(11) not null default'0',
	remark varchar(100) comment'备注',
	created int(11) not null comment'创建时间',
	updated int(11) comment'修改时间',
	deleted tinyint(4) default'0' comment'0表示未删除 1表示已删除',
	KEY `index_author` (`author`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 comment'新闻信息'


drop table if exists Comment;
create table Comment(
	id int(11)  PRIMARY KEY auto_increment,
	newsId int(11) not null comment'此条评论所属新闻id',
	commentContent varchar(200) not null comment'评论内容',
	owerId int(11) not null comment'评论人id',
	ower varchar(20) not null comment'评论人',
	created int(11) not null comment'创建时间',
	isCheck tinyint(4) not null default'0' comment'审核 0表示未审核 1表示已经审核',
	deleted tinyint(4) not null default '0' comment'删除 0表示未删除 1表示已删除',
	remark varchar(100) comment'备注',
	key index_newsId(newsId),
	key index_owerId(owerid)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 comment'评论信息表';

show variables like '%time_zone%'
set time_zone = '+8:00';
flush privileges;//设置mysql时区