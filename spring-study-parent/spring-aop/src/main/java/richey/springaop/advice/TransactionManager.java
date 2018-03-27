package richey.springaop.advice;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;
import java.sql.SQLException;

/**
 * 异常抛出增强
 * ThrowsAdvice是个标识接口
 * @author richey
 */
public class TransactionManager implements ThrowsAdvice {

    /**
     * 方法名必须是afterThrowing
     * 前三个参数是可选的（要么都选，要么都不选）
     * 最后一个参数是Throwable或其子类
     *
     * 可以提供多个方法签名不同的afterThrowing方法，Spring会自动选用最匹配的增强方法
     * @param method
     * @param args
     * @param target
     * @param ex
     */
    public void afterThrowing(Method method, Object[] args, Object target, SQLException ex) {
        System.out.println("---------------");
        System.out.println("Method:"+method.getName());
        System.out.println("抛出异常："+ ex.getMessage());
        System.out.println("成功回滚事务。");
    }


}
