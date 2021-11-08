package proxy;


/**
 * @author 曹先森
 * @version V1.0
 * @description
 * @date 2021年11月07日 15:47
 */
public class Order implements  IOrder{
    //状态为 0 ：未支付  1 ：已支付
    int state = 0;

    @Override
    public void pay() throws InterruptedException {
        Thread.sleep(50);
        this.state = 1;
    }


    @Override
    public void show() {
        System.out.println("ordew state " + this.state);
    }
}
