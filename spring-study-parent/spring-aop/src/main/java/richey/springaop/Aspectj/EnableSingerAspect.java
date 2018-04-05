package richey.springaop.Aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * 引介切面  让SuperSinger充当Dancer的角色
 * @author richey
 */
@Aspect
public class EnableSingerAspect {

    @DeclareParents(value = "richey.springaop.Aspectj.SuperSinger", //为SuperSinger添加接口实现
            defaultImpl = SuperDancer.class) //默认的接口实现类
    public Dancer dancer; //要实现的接口

}
