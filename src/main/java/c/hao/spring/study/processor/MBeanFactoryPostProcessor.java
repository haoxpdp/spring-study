package c.hao.spring.study.processor;

import c.hao.spring.study.api.ApiFactory;
import c.hao.spring.study.api.TestApi;
import c.hao.spring.study.bean.TestFactory;
import c.hao.spring.study.service.OrderService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;

import javax.annotation.Resource;

public class MBeanFactoryPostProcessor implements BeanFactoryPostProcessor, BeanDefinitionRegistryPostProcessor, ResourceLoaderAware {

    ResourceLoader loader;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryPostProcessor的postProcessBeanFactory方法正在调用...");

    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("postProcessBeanDefinitionRegistry");
        BeanDefinition beanDefinition;
//        BeanDefinitionHolder holder = new BeanDefinitionHolder(beanDefinition, );
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(TestApi.class);
        GenericBeanDefinition bd = (GenericBeanDefinition) beanDefinitionBuilder.getBeanDefinition();
        bd.setBeanClassName(ApiFactory.class.getName());
        bd.setBeanClass(ApiFactory.class);
        bd.getConstructorArgumentValues().addGenericArgumentValue(TestApi.class);

        registry.registerBeanDefinition("factory", beanDefinitionBuilder.getBeanDefinition());
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.loader = resourceLoader;
    }
}
