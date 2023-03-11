package com.nowcoder.community.dao;

import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {

    List<DiscussPost> selectDiscussPosts(int userId,int offset,int limit);

    List<DiscussPost> intelligentSelect(int userType,int offset,int limit);
    int intelligentSelectRows(int userType);

    //@param给参数起别名，，，如果只有一个参数且在<if>里面使用就一定要加param；
    int selectDiscussPostRows(@Param("userId") int userId);

    int insertDiscussPost(DiscussPost discussPost);

    DiscussPost selectDiscussPostById(int id);

    int updateCommentCount(int id,int commentCount);

    int updateType(int id ,int type);

    int updateStatus(int id,int status);

    int updateUserType(int id,int userType);


}
