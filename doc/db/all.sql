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
  `level` char(1) DEFAULT NULL COMMENT '级别|枚举[CourseLevelEnum]:ONE("1","初级"),TWO("1","初级"),THREE("1","初级")',
  `charge` char(1) DEFAULT NULL COMMENT '收费|枚举[CourseChargeEnum]:CHARGE("C","收费"),FREE("F","免费")',
  `status` char(1) DEFAULT NULL COMMENT '状态|枚举[CourseStatusEnum]:PUBLISH("P","发布"),DRAFT("D","草稿")',
  `enroll` int(11) DEFAULT '0' COMMENT '报名数',
  `sort` int(11) DEFAULT NULL COMMENT '顺序',
  `created_at` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_at` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='课程';

INSERT INTO courseimooc.course (id, name, summary, time, price, image, level, charge, status, enroll, sort, created_at, updated_at)
VALUES ('00000001', '测试课程01', '这是一门测试课程', 7200, 19.9, '', 0, 'C', 'D', 100, 0, now(), now());
/*************************分类*******************************/
drop table if exists `category`;
CREATE TABLE `category` (
    `id` char(8) NOT NULL default '' COMMENT 'id',
    `parent` char(8) NOT NULL default '' COMMENT '父id',
    `name` varchar(50) NOT NULL COMMENT '名称',
    `sort` int(11)  COMMENT '顺序',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 comment='分类';
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000100', '00000000', '前端技术', 100);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000101', '00000100', 'Vue.js', 101);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000102', '00000100', 'Typescript', 102);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000103', '00000100', 'React.JS', 103);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000104', '00000100', 'HTML/CSS', 104);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000105', '00000100', 'JavaScript', 105);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000106', '00000100', 'Angular', 106);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000107', '00000100', 'Node.js', 107);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000108', '00000100', 'WebApp', 108);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000109', '00000100', '小程序', 109);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000110', '00000100', '前端工具', 110);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000111', '00000100', 'CSS', 111);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000112', '00000100', 'Html5', 112);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000113', '00000100', 'CSS3', 113);

INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000200', '00000000', '后端技术', 200);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000201', '00000200', 'Java', 201);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000202', '00000200', 'SpringBoot', 202);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000203', '00000200', 'Spring Cloud', 203);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000204', '00000200', 'SSM', 204);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000205', '00000200', 'PHP', 205);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000206', '00000200', '.net', 206);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000207', '00000200', 'Python', 207);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000208', '00000200', '爬虫', 208);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000209', '00000200', 'Django', 209);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000210', '00000200', 'Flask', 210);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000211', '00000200', 'Go', 211);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000212', '00000200', 'C', 212);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000213', '00000200', 'C++', 213);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000214', '00000200', 'C#', 214);


INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000300', '00000000', '移动开发', 300);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000301', '00000300', 'Flutter', 301);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000302', '00000300', 'Android', 302);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000303', '00000300', 'iOS', 303);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000304', '00000300', 'React native', 304);

INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000400', '00000000', '计算机基础', 400);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000401', '00000400', '计算机网络', 401);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000402', '00000400', '算法与数据结构', 402);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000403', '00000400', '数学', 403);

INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000500', '00000000', '前沿技术', 500);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000501', '00000500', '微服务', 501);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000502', '00000500', '区块链', 502);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000503', '00000500', '机器学习', 503);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000504', '00000500', '深度学习', 504);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000505', '00000500', '计算机视觉', 505);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000506', '00000500', '自然语言处理', 506);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000507', '00000500', '数据分析&挖掘', 507);

INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000600', '00000000', '云计算&大数据', 600);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000601', '00000600', '大数据', 601);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000602', '00000600', 'Hadoop', 602);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000603', '00000600', 'Spark', 603);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000604', '00000600', 'Hbase', 604);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000605', '00000600', 'Flink', 605);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000606', '00000600', 'Storm', 606);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000607', '00000600', '阿里云', 607);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000608', '00000600', '容器', 608);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000609', '00000600', 'Docker', 609);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000610', '00000600', 'Kubernetes', 610);


INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000700', '00000000', '运维&测试', 700);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000701', '00000700', '运维', 701);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000702', '00000700', '自动化运维', 702);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000703', '00000700', '中间件', 703);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000704', '00000700', 'Linux', 704);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000705', '00000700', '测试', 705);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000706', '00000700', '功能测试', 706);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000707', '00000700', '性能测试', 707);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000708', '00000700', '自动化测试', 708);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000709', '00000700', '接口测试', 709);


INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000800', '00000000', '数据库', 800);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000801', '00000800', 'MySQL', 801);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000802', '00000800', 'Redis', 802);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000803', '00000800', 'MongoDB', 803);


INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000900', '00000000', 'UI设计&多媒体', 900);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000901', '00000900', '设计基础', 901);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000902', '00000900', '设计工具', 902);
INSERT INTO category(`id`, `parent`, `name`, `sort`) VALUES ('00000903', '00000900', 'APPUI设计', 903);


/*课程分类*/
drop table if exists `course_category`;
CREATE TABLE `course_category` (
       `id` char(8) NOT NULL COMMENT 'id',
       `course_id` char(8) DEFAULT NULL COMMENT '课程|course.id',
       `category_id` char(8) DEFAULT NULL COMMENT '分类|course.id',
       PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 comment='课程分类' ;

/*课程内容*/
drop table if exists `course_content`;
CREATE TABLE `course_content` (
      `id` char(8) NOT NULL COMMENT '课程id',
      `content` mediumblob NOT NULL COMMENT '课程内容',
      PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 comment='课程内容';







