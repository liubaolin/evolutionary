package richey.springaop.advice.entity;

/**
 * @author richey
 */
public class Engineer implements People {

    @Override
    public void eat(String place) {
        System.out.println("到"+place+"去吃饭啦！");
    }


}
