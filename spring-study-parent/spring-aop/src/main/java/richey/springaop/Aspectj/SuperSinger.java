package richey.springaop.Aspectj;

public class SuperSinger implements Singer {
    @Override
    public void sing() {
        System.out.println("我们不一样，不一样，每个人都有不同的境遇~~~~~");
    }
}
