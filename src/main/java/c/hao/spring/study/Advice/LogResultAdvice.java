package c.hao.spring.study.Advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @author by haoxpdp
 * @date 19-4-3 下午5:46
 */
public class LogResultAdvice implements AfterReturningAdvice {

    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println(method.getName() + "方法返回：" + returnValue);
    }
}
