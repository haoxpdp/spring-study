package c.hao.spring.study.api;

import org.springframework.beans.factory.FactoryBean;

public class ApiFactory<T> implements FactoryBean<T> {

    private Class<?> clz;

    public ApiFactory(Class<?> clazz) {
        this.clz = clazz;
    }

    @Override
    public T getObject() throws Exception {
        return (T) new Api();
    }

    @Override
    public Class<?> getObjectType() {
        return clz;
    }
}
