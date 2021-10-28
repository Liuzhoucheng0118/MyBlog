import com.MyBlogApplication;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzc.blog.controller.TypeController;
import com.lzc.blog.pojo.Type;
import com.lzc.blog.pojo.User;
import com.lzc.blog.service.TypeService;
import com.lzc.blog.service.UserService;
import com.lzc.blog.service.impl.TypeServiceImpl;
import com.lzc.blog.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;


@SpringBootTest(classes = MyBlogApplication.class)
public class MyTest {
    @Autowired
    private TypeService typeService;
    @Test
    public void userTest() {
        UserService userService = new UserServiceImpl();
        User admin = userService.cheackUser("admin");
        System.out.println(admin);
    }

    @Test
    public void typetest(){

        Page<Type> page = new Page<Type>(1,5);
        Page<Type> typeList = typeService.page(page,null);
        System.out.println(typeList.getSize());
    }

    @Test
    public void typetest1(){
        Type typename = typeService.getByTypename("SpringBoot");
        System.out.println(typename.toString());
    }
}
