package sword.offer;

import designmode.proxy.CglibProxy;
import designmode.proxy.Childern;

/**
 * @Author: zhangchaozhen
 * @Description: TODO
 * @Date: 2020/2/22 下午10:49
 **/
public class CglibTest {
    public static void main(String[] args) {
        Childern childern = (Childern) new CglibProxy(new Childern()).getProxy();
        childern.school();
        childern.money();
    }
}
