package online.ronakon.stockmanagement.aspects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
@Deprecated
public class BeforeAfterAspect {
    private static final Logger LOGGER = LogManager.getLogger(BeforeAfterAspect.class);

//    @Before("execution(* com.example.demomavenaopab..*(..)))")
    @Before("execution(* online.ronakon.stockmanagement..*(..)))")
    public void logBeforeAllMethodCall(JoinPoint joinPoint) throws Throwable {
        LOGGER.info("👉======== BEFORE ==========");
        LOGGER.info("👉======== START WITH METHOD " + joinPoint.getSignature().getName()); // METHOD NAME;
    }

    @After("execution(* online.ronakon.stockmanagement..*(..)))")
    public void logAfterMethodCall(JoinPoint joinPoint) throws Throwable {
        LOGGER.info("👉======== AFTER ==========");
        LOGGER.info("👉======== COMPLETED EXECUTION OF METHOD " + joinPoint.getSignature().getName()); // METHOD NAME;
    }
}
