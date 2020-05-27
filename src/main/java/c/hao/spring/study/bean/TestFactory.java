package c.hao.spring.study.bean;

import org.springframework.beans.factory.InitializingBean;

public class TestFactory implements InitializingBean {
    public TestFactory() {
        System.out.println("factory build!");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("after factory initialize");
    }

    public void test() {
        System.out.println("factory test");
    }
}
