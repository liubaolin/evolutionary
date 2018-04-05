# richey.springaop.proxy

* Spring AOP是基于代理的方式实现的
* 该模块主要展示了代理的基础知识和用法
* 包含了基于JDK的代理方式和基于CGlib的代理方式


# 使用@AspectJ设置切面

## Quick Start

### 通过编程的方式织入@AspectJ切面
    PreDriveAspect#beforeDrive()
    PreDriveAspectTest#beforeDriveTest()

### 通过配置使用@AspectJ切面

     <!--通过配置使用@AspectJ切面-->
     <bean class="richey.springaop.Aspectj.PreDriveAspect"/>
     <!--方式1:自动代理创建，自动将@AspectJ注解的切面织入到目标bean中-->
     <bean class="org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator"/>
     <!--方式2:基于Schema的aop命名空间进行配置  方式1和方式2用其中一种就可以了-->
     <aop:aspectj-autoproxy/>