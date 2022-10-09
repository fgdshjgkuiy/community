package com.nowcoder.community.util;

public interface CommunityConstant {
    //激活状态
    int ACTIVATION_SUCCESS=0;
    int ACTIVATION_REPEAT=1;
    int ACTIVATION_FAILURE=2;

    //登录凭证超时间
    int DEFAULT_EXPIRED_SECONDS=3600*12;
    int REMEMBERME_EXPIRED_SECONDS=3600*24*100;

    int ENTITY_TYPE_POST=1;
    int ENTITY_TYPE_COMMENT=2;
    int ENTITY_TYPE_USER=3;

    /*
    主题 评论，点赞，关注
     */
    String TOPIC_COMMENT = "comment";
    String TOPIC_LIKE="like";
    String TOPIC_FOLLOW="follow";
    String TOPIC_PUBLISH = "publish";
    String TOPIC_DELETE = "delete";

    /*
    系统用户id
     */
    int SYSTEM_USER_ID = 1;

    /*
        权限:普通用户，管理员，版主
     */
    String AUTHORITY_USER="user";
    String AUTHORITY_ADMIN="admin";
    String AUTHORITY_MODERATOR="moderator";


}
