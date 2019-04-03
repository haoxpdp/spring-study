package c.hao.spring.study;

import c.hao.spring.study.bean.Car;
import c.hao.spring.study.service.OrderService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;


/**
 * @author by haoxpdp
 * @date 19-2-14 下午5:13
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:beans.xml");
        OrderService orderService = (OrderService) applicationContext.getBean("orderServiceImpl");
        orderService.createOrder("haoxpdp","test");
        orderService.queryOrder("haoxpdp");

    }
}
