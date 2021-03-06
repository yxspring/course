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

