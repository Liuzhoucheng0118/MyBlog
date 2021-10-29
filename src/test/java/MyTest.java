


import com.MyBlogApplication;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzc.blog.condition.BlogCondition;
import com.lzc.blog.mapper.BlogMapper;
import com.lzc.blog.pojo.Blog;

import com.lzc.blog.pojo.Type;
import com.lzc.blog.pojo.User;
import com.lzc.blog.service.TagService;
import com.lzc.blog.service.TypeService;
import com.lzc.blog.service.UserService;
import com.lzc.blog.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest(classes = MyBlogApplication.class)
public class MyTest {
    @Autowired
    private TypeService typeService;

    @Resource
    private BlogMapper blogMapper;

    @Test
    public void userTest() {
        UserService userService = new UserServiceImpl();
        User admin = userService.cheackUser("admin");
        System.out.println(admin);
    }

    @Test
    public void tagtest() {

        Page<Type> page = new Page<Type>(1, 5);
        Page<Type> tagList = typeService.page(page, null);
        System.out.println(tagList.getSize());
    }

    @Test
    public void tagtest1() {
        Integer javaSE = typeService.updateType(new Type(1L, "JavaSE", null));
        System.out.println(javaSE);
    }

    @Test
    public void tagtest2() {
        IPage<Blog> blogIPage = blogMapper.selectBlogs(new Page<Blog>(1, 5));
        System.out.println(blogIPage.getSize());
        Blog blog = blogIPage.getRecords().get(0);
        System.out.println(blog.toString());

//        BlogCondition s = new BlogCondition("s", null);
//        IPage<Blog> s1 = blogMapper.selectByCondition(new Page<Blog>(1, 5), new BlogCondition("s", null));
//                System.out.println(blogIPage.getSize());
//        Blog blog = blogIPage.getRecords().get(0);
//        System.out.println(blog.toString());
    }
}
