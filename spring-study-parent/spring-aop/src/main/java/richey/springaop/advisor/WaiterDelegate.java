package richey.springaop.advisor;

import richey.springaop.entity.Waiter;

/**
 * 通过WaiterDelegate类代理Waiter类的所有方法
 * 用来测试流程切面
 */
public class WaiterDelegate {

    private Waiter waiter;

    public void service(String clientName) {
        waiter.greetTo(clientName);
        waiter.serveTo(clientName);
    }

    public Waiter getWaiter() {
        return waiter;
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }
}
