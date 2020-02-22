package designmode.proxy;

/**
 * @Author: zhangchaozhen
 * @Description: 真实主题
 * @Date: 2020/2/22 下午10:28
 **/
public class Childern implements IChildern {
    @Override
    public void money() {
        System.out.println("孩子交学费。。。");
    }

    @Override
    public void school() {
        System.out.println("孩子去上学。。。");
    }
}
