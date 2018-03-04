drop table if exists sys_user;
drop table if exists sys_organization;
drop table if exists sys_resource;
drop table if exists sys_role;

-- 用户表
create table sys_user (
  id bigint auto_increment,
  organization_id bigint,
  username varchar(100),
  password varchar(100),
  salt varchar(100),
  role_ids varchar(100) comment '角色列表',
  locked bool default false ,
  constraint pk_sys_user primary key(id)
) charset=utf8 ENGINE=InnoDB;
create unique index idx_sys_user_username on sys_user(username);
create index idx_sys_user_organization_id on sys_user(organization_id);

-- 组织表
create table sys_organization (
  id bigint auto_increment,
  name varchar(100),
  parent_id bigint comment '父编号',
  parent_ids varchar(100) comment '父编号列表',
  available bool default false,
  constraint pk_sys_organization primary key(id)
) charset=utf8 ENGINE=InnoDB;
create index idx_sys_organization_parent_id on sys_organization(parent_id);
create index idx_sys_organization_parent_ids on sys_organization(parent_ids);

-- 资源表
create table sys_resource (
  id bigint auto_increment,
  name varchar(100),
  type varchar(50) comment '资源类型',
  priority int comment '排序',
  url varchar(200) comment '资源链接',
  parent_id bigint comment '父编号',
  parent_ids varchar(100) comment '父编号列表',
  permission varchar(100) comment '权限',
  available bool default false,
  constraint pk_sys_resource primary key(id)
) charset=utf8 ENGINE=InnoDB;
create index idx_sys_resource_parent_id on sys_resource(parent_id);
create index idx_sys_resource_parent_ids on sys_resource(parent_ids);

-- 角色表
create table sys_role (
  id bigint auto_increment,
  role varchar(100) comment '角色名',
  description varchar(100) comment '说明',
  resource_ids varchar(100) comment '资源列表',
  available bool default false,
  constraint pk_sys_role primary key(id)
) charset=utf8 ENGINE=InnoDB;
create index idx_sys_role_resource_ids on sys_role(resource_ids);