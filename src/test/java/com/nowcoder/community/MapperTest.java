package com.nowcoder.community;

import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.dao.LoginTicketMapper;
import com.nowcoder.community.dao.MessageMapper;
import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.LoginTicket;
import com.nowcoder.community.entity.Message;
import com.nowcoder.community.entity.User;
import net.bytebuddy.asm.Advice;
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
public class MapperTest {

    @Autowired
    private LoginTicketMapper loginTicketMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DiscussPostMapper discussPostMapper;
    @Autowired
    private MessageMapper messageMapper;
    @Test
    public void testSelectUser(){
         User user = userMapper.selectById(101);
        System.out.println(user);

        user =userMapper.selectByName("liubei");
        System.out.println(user);

        user = userMapper.selectByEmail("nowcoder101@sina.com");
        System.out.println(user);
    }
    @Test
    public void testInsertUser(){
         User user = new User();
         user.setUsername("test2");
         user.setPassword("1234");
         user.setSalt("abc");
         user.setEmail("testqq.com");
         user.setHeaderUrl("http://www.nowcoder.com/101.png");
         user.setCreaTime(new Date());

         int rows= userMapper.insertUser(user);
        System.out.println(rows);
        System.out.println(user.getId());
    }
    @Test
    public void updateUser(){
        int row=userMapper.updateStatus(150,1);
        System.out.println(row);

         row=userMapper.updateHeader(150,"http://www.nowcoder.com/102.png");
        System.out.println(row);

        row=userMapper.updatePassword(150,"heks15");
        System.out.println(row);
    }
    @Test
    public  void testSelectPosts(){
        List<DiscussPost> discussPosts = discussPostMapper.selectDiscussPosts(0, 0, 10);
        for(DiscussPost post:discussPosts){
            System.out.println(post);
        }

        int rows = discussPostMapper.selectDiscussPostRows(0);
        System.out.println(rows);
    }

    @Test
    public void testInsertLoginTicket() {
        LoginTicket loginTicket = new LoginTicket();
        loginTicket.setUserId(101);
        loginTicket.setTicket("abc");
        loginTicket.setStatus(0);
        loginTicket.setExpired(new Date(System.currentTimeMillis() + 1000 * 60 * 10));

        loginTicketMapper.insertLoginTicket(loginTicket);
    }
    @Test
    public void testSelectLoginTicket() {
        LoginTicket loginTicket = loginTicketMapper.selectByTicket("abc");
        System.out.println(loginTicket);

        loginTicketMapper.updateStatus("abc", 1);
        loginTicket = loginTicketMapper.selectByTicket("abc");
        System.out.println(loginTicket);
    }

    @Test
    public void testSelectLetters(){
        List<Message> list = messageMapper.selectConversations(111, 0, 20);

        int count = messageMapper.selectConversationCount(111);
        System.out.println(count);

        list = messageMapper.selectLetters("111_112",0,10);
        for(Message message:list){
            System.out.println(message);
        }

        count = messageMapper.selectLetterCount("111_112");
        System.out.println(count);

        count=messageMapper.selectLetterUnreadCount(131,"111_131");
        System.out.println(count);
    }

    @Test
    public void intelligent(){
        List<DiscussPost> list = discussPostMapper.intelligentSelect(1, 0, 5);
        for(DiscussPost i:list){
            System.out.println(i);
        }
        System.out.println(discussPostMapper.intelligentSelectRows(1));
    }

}
