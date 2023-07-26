package com.xinan.methodtrack.aop;

import com.xinan.methodtrack.annotation.MethodTrack;
import com.xinan.methodtrack.pojo.Health;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lilg
 * @date 2023/7/24
 */
@Aspect
@Component
@Slf4j
public class MethodTrackAspect {
    public static Map<String, Health> methodTrackDataMap = new ConcurrentHashMap<>();

    @Pointcut("@annotation(com.xinan.methodtrack.annotation.MethodTrack)")
    public void methodTrackCut() {
    }


    @Around("methodTrackCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        Object result;
        String key = getName(method);
        Health health = new Health();
        MethodTrack annotation = method.getAnnotation(MethodTrack.class);
        Class<? extends Throwable>[] exceptions = annotation.excludes();
        try {
            result = point.proceed();
            health.setSuccess(true);
            health.setLastCallTime(System.currentTimeMillis());

            methodTrackDataMap.put(key, health);
        } catch (Throwable e) {
            health.setSuccess(false);
            health.setLastCallTime(System.currentTimeMillis());
            methodTrackDataMap.put(key, health);
            for (Class<? extends Throwable> exception : exceptions) {
                Throwable cause = e.getCause();
                if (exception.isInstance(cause)){
                    throw cause;
                }
            }
            throw e;
        }
        return result;
    }

    public String getName(Method method) {
        MethodTrack annotation = method.getAnnotation(MethodTrack.class);
        String value = annotation.value();
        if ("".equals(value) || value.isEmpty()) {
            String methodName = method.getName();
            String className = method.getDeclaringClass().getName();
            return className + "." + methodName;
        }
        return value;
    }

}
