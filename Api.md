# 接口文档



## 接口url

网络接口使用http协议和restful风格的api设计

[如何设计restful风格的api](http://www.ruanyifeng.com/blog/2014/05/restful_api.html)

注：是否包含status在后续开发中决定

- POST/toLogin：用户登录
  - 在request body中包含Login user的具体信息
  - 返回具体的信息 Json(SysUser)，登陆成功还是失败的status

- GET /ranking：获取排行榜
  - 返回排行榜信息，包含status
- 返回 Json(pageInfo)
  
- POST /users：新建用户
  - 返回新建用户信息，包含status

- PUT /users/{id}：更新用户信息

- 返回更新的用户信息，包含status

- GET /users/{id}：获取用户信息
  - 返回用户信息，包含status



## status 状态码

接口发送的json数据经过封装，包含状态码，实现了Java Bean规范，参考[blog](https://blog.csdn.net/aiyaya_/article/details/78209992)

分别是状态码code，状态注释msg，数据对象data，符合restful规范

```java
/* 成功状态码 */
SUCCESS(1, "成功"),

/* 参数错误：10001-19999 */
PARAM_IS_INVALID(10001, "参数无效"),
PARAM_IS_BLANK(10002, "参数为空"),
PARAM_TYPE_BIND_ERROR(10003, "参数类型错误"),
PARAM_NOT_COMPLETE(10004, "参数缺失"),

/* 用户错误：20001-29999*/
USER_NOT_LOGGED_IN(20001, "用户未登录"),
USER_LOGIN_ERROR(20002, "账号不存在或密码错误"),
USER_ACCOUNT_FORBIDDEN(20003, "账号已被禁用"),
USER_NOT_EXIST(20004, "用户不存在"),
USER_HAS_EXISTED(20005, "用户已存在"),

/* 业务错误：30001-39999 */
SPECIFIED_QUESTIONED_USER_NOT_EXIST(30001, "某业务出现问题"),

/* 系统错误：40001-49999 */
SYSTEM_INNER_ERROR(40001, "系统繁忙，请稍后重试"),

/* 数据错误：50001-599999 */
RESULE_DATA_NONE(50001, "数据未找到"),
DATA_IS_WRONG(50002, "数据有误"),
DATA_ALREADY_EXISTED(50003, "数据已存在"),

/* 接口错误：60001-69999 */
INTERFACE_INNER_INVOKE_ERROR(60001, "内部系统接口调用异常"),
INTERFACE_OUTTER_INVOKE_ERROR(60002, "外部系统接口调用异常"),
INTERFACE_FORBID_VISIT(60003, "该接口禁止访问"),
INTERFACE_ADDRESS_INVALID(60004, "接口地址无效"),
INTERFACE_REQUEST_TIMEOUT(60005, "接口请求超时"),
INTERFACE_EXCEED_LOAD(60006, "接口负载过高"),

/* 权限错误：70001-79999 */
PERMISSION_NO_ACCESS(70001, "无访问权限");
```



## json数据格式

LoginUser{

​	userId;

​	userName:

​	userPassword:

}

pageInfo{

​	pageNum;

​	pageSize;

​	total;

​	pages;

​	List<T> list;

​	int navigatePages;

​	int[] navigatepageNums;

}

```
public class SysUser extends BaseEntity {

    private Long userId;

    private String userName;

    private String userPassword;

    private String userEmail;

    private Date createTime;

    private Long money;

    private Long grade;

    private String userInfo;

    private byte[] headImg;


}
```