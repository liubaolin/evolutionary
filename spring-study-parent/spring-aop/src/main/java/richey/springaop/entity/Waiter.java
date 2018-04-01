package richey.springaop.entity;

public class Waiter {

    public void greetTo(String name) {
        System.out.println("waiter greet to " + name + "...");
    }

    public void serveTo(String name) {
        System.out.println("waiter serve to " + name + "...");
    }

}
