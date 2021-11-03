import com.MyBlogApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest(classes = MyBlogApplication.class)
public class Test11 {
    @Test
    public void sada(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode("7wzhzgmqmzllzj");
        System.out.println(encode);

    }
}
