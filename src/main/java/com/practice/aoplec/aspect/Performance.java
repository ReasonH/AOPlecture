package com.practice.aoplec.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

// Aspect - Performance
@Aspect
public class Performance {

    // Advice - when: 타겟 호출 전/후(@Around), what: 시간 측정(calctime method)
    // Pointcut specifier - execution
    // Target spec - com.~~~.getBoards()
    @Around("execution(* com.practice.aoplec.service.board.BoardService.getBoards(..))")
    public Object calculationPerformanceTime(ProceedingJoinPoint proceedingJoinPoint) {
        Object result = null;
        try {
            long start = System.currentTimeMillis();
            result = proceedingJoinPoint.proceed();
            long end = System.currentTimeMillis();

            System.out.println("수행 시간 : "+ (end-start));
        } catch (Throwable throwable) {
            System.out.println("exception! ");
        }
        return result;
    }
}
