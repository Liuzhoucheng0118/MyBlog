import com.MyBlogApplication;
import com.lzc.blog.mapper.BlogMapper;
import com.lzc.blog.mapper.TagMapper;
import com.lzc.blog.pojo.Blog;
import com.lzc.blog.pojo.Tag;
import com.lzc.blog.service.BlogService;
import com.lzc.blog.service.TagService;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @Author 刘周城
 * @Date 2022/3/22 8:52
 * @Email 369039150@qq.com
 */
@SpringBootTest(classes = MyBlogApplication.class)
public class TestMapper {

    @Autowired
    BlogService blogService;

    @Autowired
    TagService tagService;

    @Test
    public void tes() {
    Blog blog = new Blog();
        if(StringUtils.isNotBlank(blog.getDescription()) && blog.getDescription().contains("C6")){
            System.out.println("1111");
        }



    }
}
