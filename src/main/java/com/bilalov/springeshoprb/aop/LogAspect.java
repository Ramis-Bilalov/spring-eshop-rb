package com.bilalov.springeshoprb.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.bilalov.springeshoprb.controllers..*.*(..))")
    private void anyMethod() {

    }

    @After("anyMethod()")
    public void logAfterThrowing(JoinPoint joinPoint) {
        logger.info("Log after: " + joinPoint.toShortString());
    }

}
