package richey.springaop.proxy;

/**
 * @author richey
 */
public class PerformanceMonitor {

    private static ThreadLocal<MethodPerformance> performanceRecords = new ThreadLocal<MethodPerformance>();

    public static void begin(String serviceMethod) {
        System.out.println("begin monitor");
        MethodPerformance mp = new MethodPerformance(serviceMethod);
        performanceRecords.set(mp);
    }

    public static void end() {
        System.out.println("end monitor");
        MethodPerformance mp = performanceRecords.get();
        mp.printPerformance();
    }

}
