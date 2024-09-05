package com.bhs.examples.springtutorial;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;

@Aspect
@Component
public class TimeMonitorClass implements TimeMonitor{

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
    @Around("@annotation(TimeMonitor)")
    public void monitorTime(ProceedingJoinPoint joinPoint){
        long start = System.currentTimeMillis();
        try{
            joinPoint.proceed();
        } catch (Throwable e) {
            System.out.println("Something went wrong");
        } finally {
            long end = System.currentTimeMillis();
            System.out.println(end - start+" ms...");
        }
    }
}
