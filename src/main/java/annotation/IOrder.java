package annotation;

/**
 * @author 曹先森
 * @version V1.0
 * @description
 * @date 2021年11月07日 15:46
 */
public interface IOrder {

    void pay() throws InterruptedException;

    void show();
}
