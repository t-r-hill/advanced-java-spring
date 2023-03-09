package platform.codingnomads.co.aspectorientedprogramming.lab.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;

@Aspect
@Component
public class GreetingServiceAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(GreetingServiceAspect.class);

    @Pointcut("execution(* platform.codingnomads.co.aspectorientedprogramming.lab.service.GreetingService.greeting())")
    public void logGreeting(){}

    @Pointcut("execution(* platform.codingnomads.co.aspectorientedprogramming.lab.service.GreetingService.farewell())")
    public void logFarewell(){}

    @Before("logFarewell()")
    public void logBeforeFarewell(){
        LOGGER.info("Before farewell");
    }

    @AfterReturning("logFarewell()")
    public void logAfterFarewell(){
        LOGGER.info("After returning farewell");
    }

    @Before("logGreeting()")
    public void logBeforeGreeting(JoinPoint joinPoint){
        LOGGER.info("Before greeting");
    }

    @AfterReturning("logGreeting()")
    public void logAfterGreeting(JoinPoint joinPoint){
        LOGGER.info("After returning greeting");
    }
}
