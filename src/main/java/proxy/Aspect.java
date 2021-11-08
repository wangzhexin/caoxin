package proxy;

import monad.Try;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 曹先森
 * @version V1.0
 * @description
 * @date 2021年11月07日 15:44
 */
public interface Aspect {

    void before();

    void after();

    static <T> T getProxy(Class<T> cls, String ... aspects) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        List<Try<Aspect>> list = Arrays.stream(aspects).map(name -> Try.ofFailable(() -> {
            Class clazz = Class.forName(name);
            return (Aspect) clazz.getConstructor().newInstance();

        }))
                .filter(aspect -> aspect.isSuccess())
                .collect(Collectors.toList());

        T t = cls.getConstructor().newInstance();


        return (T) Proxy.newProxyInstance(
                cls.getClassLoader(),
                cls.getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        for (Try<Aspect> aspectTry : list) {
                            aspectTry.get().before();
                        }

                        Object invoke = method.invoke(t);

                        for (Try<Aspect> aspectTry : list) {
                            aspectTry.get().after();
                        }


                        return invoke;
                    }
                }
        );
    }
}
