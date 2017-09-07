package javatest.common.override;

/**
 * DESCRIPTION: 子类
 *
 * @author richey
 * @create 2017-09-06-下午10:15
 */
public class OverrideChildren extends  OverrideParent{

    @Override
    public void overrideMethod() {
        super.overrideMethod();
        System.out.println("this is a children Method");
    }

    public static void main(String[] args) {
        OverrideParent parent = new OverrideChildren();
        parent.overrideMethod();
    }

}
