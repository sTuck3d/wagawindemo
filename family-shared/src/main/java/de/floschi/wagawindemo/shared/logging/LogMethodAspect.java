package de.floschi.wagawindemo.shared.logging;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogMethodAspect {


    @Around("@annotation(de.floschi.wagawindemo.shared.logging.LogMethod)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());

        logStart(logger, joinPoint);

        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;

        logEnd(logger, joinPoint, executionTime, result);

        return result;
    }


    private void logStart(Logger logger, ProceedingJoinPoint joinPoint) {
        String methodSignature = getMethodSignature(joinPoint);
        Object[] args = joinPoint.getArgs();
        if (args.length > 0) {
            var allParameters = StringUtils.joinWith(" | ", args);
            logger.trace("{} started with parameters {}", methodSignature, allParameters);
            return;
        }
        logger.trace("{} started", methodSignature);
    }

    private void logEnd(Logger logger, ProceedingJoinPoint joinPoint, long executionTime, Object result) {
        String completeSignature = joinPoint.getStaticPart().getSignature().toLongString();
        String methodSignature = getMethodSignature(joinPoint);
        if (!completeSignature.contains("void")) {
            logger.trace("{} finished, took {} ms and returned {}", methodSignature, executionTime, result);
            return;
        }
        logger.trace("{} finished and took {} ms", methodSignature, executionTime);
    }

    private String getMethodSignature(ProceedingJoinPoint joinPoint) {
        return joinPoint.getSignature().getName() + "()";
    }
}
