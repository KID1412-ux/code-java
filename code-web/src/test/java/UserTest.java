import com.guigu.code.dto.users.MerchantOrderDto;
import com.guigu.code.dto.users.UserOrderDto;
import com.guigu.code.mapper.MerchantOrderMapper;
import com.guigu.code.mapper.UserOrderMapper;
import com.guigu.code.mapper.UsersMapper;
import com.guigu.code.pojo.MyMerchantOrder;
import com.guigu.code.pojo.MyUserOrder;
import com.guigu.code.pojo.UserOrder;
import com.guigu.code.pojo.Users;
import com.guigu.code.service.MerchantOrderService;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserTest {
    private static UsersMapper usersMapper;
    private static UserOrderMapper userOrderMapper;
    private static MerchantOrderMapper merchantOrderMapper;
    @Autowired
    private MerchantOrderService merchantOrderService;

    @BeforeClass
    public static void init() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        usersMapper = context.getBean(UsersMapper.class);
        userOrderMapper = context.getBean(UserOrderMapper.class);
        merchantOrderMapper = context.getBean(MerchantOrderMapper.class);
    }
    @Test
    public void testTest(){
        UserOrderDto dto = new UserOrderDto();
        dto.setUserId(1);
        List<MyUserOrder> myUserOrders = userOrderMapper.selectUserOrdersByDto(dto);
        for (MyUserOrder myUserOrder : myUserOrders) {
            System.out.println(myUserOrder.getCreateTime());

        }
    }

    @Test
    public void testTest2(){
        MerchantOrderDto dto = new MerchantOrderDto();
        dto.setMerchantId(1);
        dto.setStats("0");
//        List<MyMerchantOrder> orders = merchantOrderMapper.selectMerchantOrderByDto(dto);
//        for (MyMerchantOrder myMerchantOrder : orders) {
//            System.out.println(myMerchantOrder);
//        }
    }
    @Test
    public void testTest3(){
        MerchantOrderDto dto = new MerchantOrderDto();
        dto.setMerchantId(1);
        dto.setStats("0");
        List<MyMerchantOrder> orders1 = merchantOrderService.selectMerchantOrders(dto);
//        List<MyMerchantOrder> orders = merchantOrderMapper.selectMerchantOrders(dto);
        for (MyMerchantOrder myMerchantOrder : orders1) {
            System.out.println(myMerchantOrder);
        }
    }
}
