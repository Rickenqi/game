[TOC]

# 项目结构



## 客户端

使用unity



## 后端

采用java，框架选择springboot + mybatis，使用restful api提供作为数据接口
关于各类组件的版本依赖，见pom.xml
提供用户登录（包括权限控制）服务和排行榜信息。
对于云端提供更多服务，有待后续增加（如云存档）



### 数据库
数据库使用mysql，mysql版本8.x，jdbc和connector版本见pom.xml

#### 游戏信息
- 排行榜sys_ranking
  - id, user_id, user_name, user_score

其他信息待补充

#### 用户信息

其中id全部为自增主键

- 用户表sys_user
  - id, user_name, user_password, user_email, user_info, head_img, create_time
- 权限表sys_privilege
  - id, privilege_name, privilege_url
- 角色表sys_role
  - id, role_name, enabled, create_by, create_time
- 用户角色关联表sys_user_role
  - user_id, role_id
- 角色权限关联表sys_role_privilege
  - role_id, privilege_id

**注意：**	 
此处为了方便对表进行直接操作， 此处没有创建表之间的外键关系。
对于表之间的关系， 会通过业务逻辑来进行限制 。




### 服务器
#### 持久层(DAO)

使用mybatis生成mapper，既数据库交互，针对每一张表生成一个mapper文件。

#### 业务层(service)

使用springboot框架，负责业务逻辑。

- 根据数据库信息生成排行榜
  - 进行排序，封装成Ranking，最后返回list
  - 进行筛选数据，一次取50条
- 根据数据库生成用户信息
  - 根据用户名或密码进行匹配
  - 针对不同的用户错误返回不同的结果，能区分是否存在用户

#### 展现层(web)

使用springboot框架和restful api，提供数据接口。

- 对客户端的登录反应进行判断
- 传送排行榜
- 封装数据

#### 实体类(domain)

POJO(Plain Old Java Object)

- 使用mcg生成的数据库对应实体类
- 符合客户端要求的数据类













