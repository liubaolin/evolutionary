package top.evolutionary.securitydemo.validator;

import org.springframework.beans.factory.annotation.Autowired;
import top.evolutionary.securitydemo.web.service.HelloService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyConstraintValidator implements ConstraintValidator<MyConstraint, Object> {

    @Autowired
    private HelloService helloService;

    @Override
    public void initialize(MyConstraint myConstraint) {
        System.out.println("MyConstraintValidator init");
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        System.out.println(value);
        helloService.greeting("richey");
        return false;
    }
}
