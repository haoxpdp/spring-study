package c.hao.spring.study;

import c.hao.spring.study.bean.Car;
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
        Resource resource = new ClassPathResource("beans.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
        System.out.println("beans inflate success!");
        Car car = (Car) factory.getBean("car1");
        System.out.println(car.getColor());
        Car car2 = (Car) context.getBean("car1");
        System.out.println(car2.getColor());

    }
}
