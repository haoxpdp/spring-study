package c.hao.spring.study;

import c.hao.spring.study.bean.TestFactory;
import c.hao.spring.study.service.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author by haoxpdp
 * @date 19-2-14 下午5:13
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:beans.xml");
        OrderService orderService = (OrderService) applicationContext.getBean("orderServiceImpl");
        orderService.createOrder("haoxpdp", "test");
        orderService.queryOrder("haoxpdp");

        TestFactory testFactory = applicationContext.getBean(TestFactory.class);
        testFactory.test();

    }
}
