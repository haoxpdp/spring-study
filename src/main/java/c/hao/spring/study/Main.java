package c.hao.spring.study;

import c.hao.spring.study.bean.Car;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.xml.XmlBeanFactory;
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
        Car car = (Car) factory.getBean("car1");
        System.out.println(car.getColor());

    }
}
