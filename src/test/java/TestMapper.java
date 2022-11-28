import com.MyBlogApplication;
import com.lzc.blog.mapper.BlogMapper;
import com.lzc.blog.mapper.TagMapper;
import com.lzc.blog.pojo.Blog;
import com.lzc.blog.pojo.Tag;
import com.lzc.blog.service.BlogService;
import com.lzc.blog.service.TagService;
import org.assertj.core.util.DateUtil;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.thymeleaf.util.DateUtils;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.io.*;
import java.security.PrivateKey;
import java.util.*;
import java.util.logging.SimpleFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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

//    public static void main(String[] args) throws Exception {
//
////        double i = 0.0;
////        System.out.println(i==0);
//
////
////        String type = "20";
////        String[] split = type.split(",");
////        for (String s : split) {
////            System.out.println(s);
//
//        Blog blog = null;
//        System.out.println("wuhu" + (blog == null ? "111":"222"));
//
//        }
////    }
//    public static String getWeekOfDate(Date date) {
////        String[] weekDays = { "Sun", "Mon", "Tue", "Wed", "Thur", "Fri", "Sat" };
////        Calendar cal = Calendar.getInstance();
////        cal.setTime(date);
////        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
////        if (w < 0)
////            w = 0;
////        return weekDays[w];
////        Date br = new Date("2004-08-10");
////        Date curr = new Date();
//
//return "";
//    }



    public static void main(String[] args) {
        System.out.println("11111");

    }


}
