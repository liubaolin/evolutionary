# richey.springaop.proxy

* Spring AOP是基于代理的方式实现的
* 该模块主要展示了代理的基础知识和用法
* 包含了基于JDK的代理方式和基于CGlib的代理方式


# 使用@AspectJ设置切面

## Quick Start

#### 通过编程的方式织入@AspectJ切面
    PreDriveAspect#beforeDrive()
    PreDriveAspectTest#beforeDriveTest()

#### 通过配置使用@AspectJ切面

     <!--通过配置使用@AspectJ切面-->
     <bean class="richey.springaop.Aspectj.PreDriveAspect"/>
     <!--方式1:自动代理创建，自动将@AspectJ注解的切面织入到目标bean中-->
     <bean class="org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator"/>
     <!--方式2:基于Schema的aop命名空间进行配置  方式1和方式2用其中一种就可以了-->
     <aop:aspectj-autoproxy/>

## 引介增强用法

    <bean class="richey.springaop.Aspectj.EnableSingerAspect"/>
    EnableSingerAspectTest#declareParentsTest()
    
## 切点函数示例

#### @annotation

    <bean class="richey.springaop.Aspectj.TestAspect"/>
    AspectFuntionTest#annotationTest()

#### 复合切点运算

    TestAspect#TestAspect()
    AspectFuntionTest#aspectTest()

#### 切点命名

    <bean class="richey.springaop.Aspectj.TestNamePointcut"/>
    AspectFuntionTest#aspectTest()

#### 访问连节点信息

    TestAspect#testGetJoinpointInfo()
    AspectFuntionTest#testGetJoinPointInfo()
    
#### 绑定连节点方法入参

    AspectFuntionTest#testBindJoinPointParams()

#### 绑定被代理对象实例

    TestAspect#testBindProxyObj()

#### 绑定类注解对象

    TestAspect#testBindTypeAnnotation()