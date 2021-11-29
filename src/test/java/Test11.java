import com.MyBlogApplication;
import com.lzc.blog.utils.RequestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.*;


@SpringBootTest(classes = MyBlogApplication.class)
public class Test11 {
    @Test
    public void sada() throws IOException {
        String filePath = RequestUtils.getRequest().getSession().getServletContext().getRealPath("/static/image/");
        File file = new File(filePath+"1.txt");
        if(!file.exists()){
            file.mkdirs();
        }
        FileWriter os = new FileWriter(file);
        os.write("1111");
        System.out.println(filePath);
    }
}
