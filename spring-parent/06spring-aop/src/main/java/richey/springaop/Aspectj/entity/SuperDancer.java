package richey.springaop.Aspectj.entity;

public class SuperDancer implements Dancer {
    @Override
    public void dance() {
        System.out.println(" dancing~~动恰恰动恰恰~~");
    }
}
