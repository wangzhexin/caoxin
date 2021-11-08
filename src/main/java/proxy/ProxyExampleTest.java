package proxy;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * @author 曹先森
 * @version V1.0
 * @description
 * @date 2021年11月07日 16:23
 */
public class ProxyExampleTest {


    @Test
    public void test_proxy() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, ClassNotFoundException, InterruptedException {
        IOrder order = Aspect.getProxy(Order.class, "proxy.TimeUsageAspect");
        order.pay();
        order.show();
    }


}
