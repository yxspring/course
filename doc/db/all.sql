drop table if exists `test`;
create table `test` (
                        id varchar(20) not null primary key,
                        name varchar(255) null
);

INSERT INTO courseimooc.test (id, name) VALUES ('1', 'java');
INSERT INTO courseimooc.test (id, name) VALUES ('2', 'system');