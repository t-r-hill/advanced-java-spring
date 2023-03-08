package platform.codingnomads.co.aspectorientedprogramming.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WarmUpAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("@annotation(WarmUp)")
    public void warmUpBefore(JoinPoint joinPoint){
        LOGGER.info("Warming up before running " + joinPoint.getSignature().getName());
    }
}
