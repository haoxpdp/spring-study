package c.hao.spring.study.api;

public class ApiFactory {

    private Class<?> clz;

    public ApiFactory(Class<?> clazz) {
        this.clz = clazz;
    }

}
