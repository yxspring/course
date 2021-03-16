/******************** 大章 *********************/
drop table if exists `chapter`;
create table `chapter` (
    `id` char(8) not null comment 'ID',
    `course_id` char(8)  comment '课程ID',
    `name` char(50)  comment '名称',
    primary key (`id`)
) engine=innodb default charset=utf8mb4 comment ='大章';


insert into chapter(id, course_id, name) values ('00000003','00000000','测试大章3');
insert into chapter(id, course_id, name) values ('00000004','00000000','测试大章4');
insert into chapter(id, course_id, name) values ('00000005','00000000','测试大章5');
insert into chapter(id, course_id, name) values ('00000006','00000000','测试大章6');
insert into chapter(id, course_id, name) values ('00000007','00000000','测试大章7');
insert into chapter(id, course_id, name) values ('00000008','00000000','测试大章8');
insert into chapter(id, course_id, name) values ('00000009','00000000','测试大章9');
insert into chapter(id, course_id, name) values ('00000010','00000000','测试大章10');
insert into chapter(id, course_id, name) values ('00000011','00000000','测试大章11');
insert into chapter(id, course_id, name) values ('00000012','00000000','测试大章12');
insert into chapter(id, course_id, name) values ('00000013','00000000','测试大章13');
insert into chapter(id, course_id, name) values ('00000014','00000000','测试大章14');
insert into chapter(id, course_id, name) values ('00000015','00000000','测试大章15');
insert into chapter(id, course_id, name) values ('00000016','00000000','测试大章16');
insert into chapter(id, course_id, name) values ('00000017','00000000','测试大章17');
insert into chapter(id, course_id, name) values ('00000018','00000000','测试大章18');
insert into chapter(id, course_id, name) values ('00000019','00000000','测试大章19');
insert into chapter(id, course_id, name) values ('00000020','00000000','测试大章20');
insert into chapter(id, course_id, name) values ('00000021','00000000','测试大章21');
insert into chapter(id, course_id, name) values ('00000022','00000000','测试大章22');
insert into chapter(id, course_id, name) values ('00000023','00000000','测试大章23');
insert into chapter(id, course_id, name) values ('00000024','00000000','测试大章24');

/************************** 小节 *****************/
drop table if exists `section`;
CREATE TABLE `section` (
                           `id` char(8) NOT NULL COMMENT 'ID',
                           `title` varchar(50) NOT NULL COMMENT '标题',
                           `course_id` char(8) DEFAULT NULL COMMENT '课程|course.id',
                           `chapter_id` char(8) DEFAULT NULL COMMENT '大章|chapter.id',
                           `video` varchar(200) DEFAULT NULL COMMENT '视频',
                           `time` int(11) DEFAULT NULL COMMENT '时长|单位秒',
                           `charge` char(1) DEFAULT NULL COMMENT '收费|c 收费：F免费',
                           `sort` int(11) DEFAULT NULL COMMENT '顺序',
                           `created_at` datetime DEFAULT NULL COMMENT '创建时间',
                           `update_at` datetime DEFAULT NULL COMMENT '修改时间',
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 comment='小节';
INSERT INTO `section`(`id`, `title`, `course_id`, `chapter_id`, `video`, `time`, `charge`, `sort`, `created_at`, `update_at`) VALUES ('00000001', '测试小节', '00000001', '00000000', '', 500, 'F', 1, '2021-03-12 09:29:42', '2021-03-12 09:29:42');
/********************** 课程 ************************/
DROP TABLE IF	EXISTS `course`;
CREATE TABLE `course` (
  `id` char(8) NOT NULL DEFAULT '' COMMENT 'id',
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `summary` varchar(2000) DEFAULT NULL COMMENT '概述',
  `time` int(11) DEFAULT '0' COMMENT '时长|单位秒',
  `price` decimal(8,2)  DEFAULT '0.00' COMMENT '价格(元)',
  `image` varchar(100) DEFAULT NULL COMMENT '封面',
  `level` char(1) DEFAULT NULL COMMENT '级别|ONE("1","初级"),TWO("1","初级"),THREE("1","初级")',
  `charge` char(1) DEFAULT NULL COMMENT '收费|CHARGE("C","收费"),FREE("F","免费")',
  `status` char(1) DEFAULT NULL COMMENT '状态|PUBLISH("P","发布"),DRAFT("D","草稿")',
  `enroll` int(11) DEFAULT '0' COMMENT '报名数',
  `sort` int(11) DEFAULT NULL COMMENT '顺序',
  `created_at` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_at` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='课程';

INSERT INTO courseimooc.course (id, name, summary, time, privce, image, level, charge, status, enroll, sort, created_at, updated_at)
VALUES ('00000001', '测试课程01', '这是一门测试课程', 7200, 19.9, '', 0, 'C', 'D', 100, 0, now(), now());