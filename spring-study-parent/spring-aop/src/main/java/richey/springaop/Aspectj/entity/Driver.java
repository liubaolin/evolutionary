package richey.springaop.Aspectj.entity;

/**
 * 司机类
 */
public class Driver {


    public void drive() {
        System.out.println("发车了~~~");
    }

    public String currentSpeed() {
        return "100km/h";
    }


}
