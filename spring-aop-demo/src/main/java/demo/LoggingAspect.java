package demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* demo.ShoppingCart.checkout(..))")
    public void beforeLogger(JoinPoint jp) {
//        System.out.println(jp.getSignature());
        String arg = jp.getArgs()[0].toString();

        System.out.println("Before logger with argument: " + arg);
    }

    @After("execution(* demo.ShoppingCart.checkout(..))")
    public void afterLogger() {
        System.out.println("After logger");
    }

    @Pointcut("execution(* demo.ShoppingCart.quantity(..))")
    public void afterReturningPointCut() {

    }

    @AfterReturning(pointcut = "afterReturningPointCut()", returning = "retVal")
    public void afterReturning(String retVal) {
        System.out.println("After returning: " + retVal);
    }
}
