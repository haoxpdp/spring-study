package c.hao.spring.study.Advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author by haoxpdp
 * @date 19-4-3 下午5:46
 */
public class LogArgsAdvice implements MethodBeforeAdvice {
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("准备执行方法: " + method.getName() + ", 参数列表：" + Arrays.toString(args));
    }
}
