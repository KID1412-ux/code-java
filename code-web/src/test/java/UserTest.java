import com.guigu.code.mapper.UserOrderMapper;
import com.guigu.code.mapper.UsersMapper;
import com.guigu.code.pojo.MyUserOrder;
import com.guigu.code.pojo.Users;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserTest {
    private static UsersMapper usersMapper;
    private static UserOrderMapper userOrderMapper;

    @BeforeClass
    public static void init() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        usersMapper = context.getBean(UsersMapper.class);
        userOrderMapper = context.getBean(UserOrderMapper.class);
    }
    @Test
    public void testTest(){
        List<MyUserOrder> myUserOrders = userOrderMapper.selectAllUserOrder(1);
        System.out.println(myUserOrders.size());
    }

    @Test
    public void testTest2(){
        Users user = usersMapper.userLogin("zhangshan");
        if (user.getPassword().equals("123456")){
            System.out.println(222);
        }
        else {
            System.out.println(111);
            System.out.println(user.getPassword());
        }


    }
}
