package com.nowcoder.community;

import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTests {

    @Autowired
    private UserMapper userMapper;


    @Test
    public void testSelect(){
        User user = userMapper.selectById(149);
        System.out.println(user);

        user = userMapper.selectByName("niuke");
        System.out.println(user);

        user = userMapper.selectByEmail("nowcoder149@sina.com");
        System.out.println(user);
    }

    @Test
    public void testInsert(){
        User user = new User();
        user.setUsername("jy3-5");
        user.setPassword("hello3-5");
        user.setSalt("hello");
        user.setEmail("myEmail@email.com");
        user.setType(0);
        user.setStatus(0);
        user.setActivationCode(null);
        user.setHeaderUrl("http://images.nowcoder.com/head/150.png");
        user.setCreateTime(new Date());
        int rows = userMapper.insertUser(user);
        System.out.println(rows);
    }

    @Test
    public void testUpdate(){
        int row = userMapper.updateHeader(157, "http://images.nowcoder.com/head/157.png");
        System.out.println(row);
        row = userMapper.updatePassword(157, "hello157");
        System.out.println(row);
        row = userMapper.updateStatus(157, 1);
        System.out.println(row);
    }

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Test
    public void testGetDiscussPosts(){
        List<DiscussPost> list = discussPostMapper.getDiscussPosts(101, 0, 10);
        for (DiscussPost post:
             list) {
            System.out.println(post);
        }
        int rows = discussPostMapper.getDiscussPostsNum(101);
        System.out.println(rows);
    }
}
