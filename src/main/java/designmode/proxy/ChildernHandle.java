package designmode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: zhangchaozhen
 * @Description: 代理主题
 * @Date: 2020/2/22 下午10:30
 **/
public class ChildernHandle implements InvocationHandler {

    private IChildern child;

    public ChildernHandle(IChildern child) {
        this.child = child;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object obj = null;

        /**
         *  method.getName()是获得抽象主题的方法，通过多态定位到具体实现类
         *  当在生产环境进行调用的时候，根据不同的方法名执行不同的方法
         * */
        if ("money".equals(method.getName())) {
            System.out.println("父母交学费。。。");
        }
        if ("school".equals(method.getName())) {
            obj = method.invoke(child, args);
        }
        return obj;
    }
}
