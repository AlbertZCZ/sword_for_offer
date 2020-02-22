package sword.offer;

import designmode.proxy.Childern;
import designmode.proxy.ChildernHandle;
import designmode.proxy.IChildern;

import java.lang.reflect.Proxy;

/**
 * @Author: zhangchaozhen
 * @Description: 代理测试
 * @Date: 2020/2/22 下午10:34
 **/
public class ProxyTest {
    public static void main(String[] args) {
        IChildern childern = new Childern();

        ChildernHandle handle = new ChildernHandle(childern);
        IChildern o = (IChildern) Proxy.newProxyInstance(childern.getClass().getClassLoader(), childern.getClass().getInterfaces(), handle);
        o.money();
        o.school();
    }
}
