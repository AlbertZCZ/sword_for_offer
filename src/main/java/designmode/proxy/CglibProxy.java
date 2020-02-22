package designmode.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: zhangchaozhen
 * @Description: cglib动态代理
 * @Date: 2020/2/22 下午10:42
 **/
public class CglibProxy implements MethodInterceptor {

    // 维护目标对象
    private Object object;

    public CglibProxy(Object object) {
        this.object = object;
    }

    // 给目标创建一个代理对象
    public Object getProxy() {
        // 创建工具类
        Enhancer en = new Enhancer();
        // 设置父类
        en.setSuperclass(object.getClass());
        // 设置回调函数，回调函数调用的是重写的interce方法
        en.setCallback(this);
        // 创建子类（代理对象）
        return en.create();
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object result = null;
        if ("school".equals(method.getName())) {
            result = method.invoke(this.object, objects);
        }
        if ("money".equals(method.getName())) {
            System.out.println("父母去交钱。。。");
        }
        return result;
    }
}
