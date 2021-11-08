package annotation;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.LinkedList;

/**
 * @author 曹先森
 * @version V1.0
 * @description
 * @date 2021年11月08日 15:01
 */


//用注解方式实现 动态代理
public class ObjectFactory {


     static <T> T newInstance(Class<T> clazz) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Annotation[] annotations = clazz.getAnnotations();
        LinkedList<IAspect> linkedList = new LinkedList<>();

        for (Annotation annotation : annotations) {
            if (annotation instanceof Aspect) {
                Class type = ((Aspect) annotation).type();
                IAspect iAspect = (IAspect) type.getConstructor().newInstance();
                linkedList.push(iAspect);
            }
        }
        T t = clazz.getConstructor().newInstance();

        return (T)Proxy.newProxyInstance(
                clazz.getClassLoader(),
                clazz.getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        linkedList.forEach(aspect -> aspect.before());
                        Object invoke = method.invoke(t);
                        linkedList.forEach(aspect -> aspect.after());
                        return invoke;
                    }
                }
        );
    }

    @Test
    public void test() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, InterruptedException {
        IOrder order = ObjectFactory.newInstance(Order.class);
        order.pay();
        order.show();
    }
}
