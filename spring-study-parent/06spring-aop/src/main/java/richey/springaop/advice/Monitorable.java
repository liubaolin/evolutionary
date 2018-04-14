package richey.springaop.advice;

/**
 * 监控开关接口
 * 我们通过引介为目标类实现该接口
 */
public interface Monitorable {

    public void setMonitorActive(boolean active);

}
