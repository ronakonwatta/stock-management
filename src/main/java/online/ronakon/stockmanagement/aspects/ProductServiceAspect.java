package online.ronakon.stockmanagement.aspects;

import online.ronakon.stockmanagement.monitor.Monitor;
import online.ronakon.stockmanagement.monitor.MonitorFactory;
import online.ronakon.stockmanagement.monitor.jamon.JamonMonitorFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;

@Aspect
@Component
public class ProductServiceAspect {
    private static final Logger LOGGER = LogManager.getLogger(ProductServiceAspect.class);
    private JamonMonitorFactory monitorFactory;

    public ProductServiceAspect(JamonMonitorFactory monitorFactory) {
        this.monitorFactory = monitorFactory;
    }

    @Before("execution(* online.ronakon.stockmanagement.*Service.*(..)))")
    public void logBeforeAllMethodCall(JoinPoint joinPoint) throws Throwable {
        String name = createJoinPointTraceName(joinPoint);
        LOGGER.info("  ======== BEFORE ==========");
//        LOGGER.info("  ======== START WITH METHOD " + joinPoint.getSignature().getName()); // METHOD NAME;
        LOGGER.info("  ======== START WITH METHOD " + name); // CLASS NAME + METHOD NAME;
    }

    @After("execution(* online.ronakon.stockmanagement.*Service.*(..)))")
    public void logAfterMethodCall(JoinPoint joinPoint) throws Throwable {
        String name = createJoinPointTraceName(joinPoint);
        LOGGER.info("👉======== AFTER ==========");
        LOGGER.info("👉======== COMPLETED EXECUTION OF METHOD " + name);
    }

    @Around("execution(* online.ronakon.stockmanagement.*Service.*(..)))")
    public Object monitor(ProceedingJoinPoint serviceMethod) throws Throwable {
        String name = createJoinPointTraceName(serviceMethod);
        Monitor monitor = monitorFactory.start(name);

        try {
            return serviceMethod.proceed();
        } finally {
            monitor.stop();
            // Do not modify this log message or the test will fail
            LOGGER.info("👉======== AROUND ==========");
            LOGGER.info("🚀 advice implementation - " + monitor);
        }
    }

    private String createJoinPointTraceName(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        StringBuilder sb = new StringBuilder();
        sb.append(signature.getDeclaringType().getSimpleName()); // CLASS  NAME
        sb.append('.').append(signature.getName());              // METHOD NAME
        return sb.toString();
    }
}