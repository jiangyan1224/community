package com.nowcoder.community.dao;

import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {
    List<DiscussPost> getDiscussPosts(int userId, int offset, int limit);

    // @Param用于给参数取别名，如果当前只有一个参数，且要用在<if>中，必须要取别名
    int getDiscussPostsNum(@Param("userId") int userId);
}
