package proxy;

/**
 * @author 曹先森
 * @version V1.0
 * @description
 * @date 2021年11月07日 16:15
 */
public class TimeUsageAspect implements Aspect{
    long start;
    @Override
    public void before() {
        start = System.currentTimeMillis();
    }

    @Override
    public void after() {
        long usage = System.currentTimeMillis() - start;
        System.out.format("time usage : %dms\n", usage);
    }
}
