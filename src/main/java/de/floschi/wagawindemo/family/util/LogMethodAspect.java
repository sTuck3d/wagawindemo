package de.floschi.wagawindemo.family.util;

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


    @Around("@annotation(LogMethod)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        var methodSignature = joinPoint.getSignature().getName() + "()";

        logStart(logger, methodSignature);
        logParameters(logger, joinPoint);

        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;

        logEndAndDuration(logger, methodSignature, executionTime);
        logReturnValue(logger, methodSignature, joinPoint, result);

        return result;
    }


    private void logStart(Logger logger, String methodSignature) {
        logger.trace("{} started.", methodSignature);
    }

    private void logEndAndDuration(Logger logger, String methodSignature, long executiontime) {
        logger.trace("{} finished and took {} ms.", methodSignature, executiontime);
    }

    private void logReturnValue(Logger logger, String methodSignature, ProceedingJoinPoint joinPoint, Object result) {
        String completeSignature = joinPoint.getStaticPart().getSignature().toLongString();
        if (!completeSignature.contains("void")) {
            logger.trace("{} returned {}", methodSignature, result);
        }
    }

    private void logParameters(Logger logger, ProceedingJoinPoint jointPoint) {
        Object[] args = jointPoint.getArgs();
        if (args.length > 0) {
            var allParameters = StringUtils.joinWith(" | ", args);
            logger.trace("The parameters are: {}", allParameters);
        }
    }
}
