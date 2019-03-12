package com.demo.annotation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class OperateAspect
{
    @Pointcut("@annotation(com.demo.annotation.Test)")
    public void annotationPointCut()
    {
    }
    
    @Before("annotationPointCut()")
    public void before(JoinPoint joinPoint)
    {
        MethodSignature sign = (MethodSignature)joinPoint.getSignature();
        Method method = sign.getMethod();
        Test annotation = method.getAnnotation(Test.class);
        System.out.println("打印:" + annotation.value() + "开始前");
    }
    
    @Around("annotationPointCut()")
    public Object advice(ProceedingJoinPoint joinPoint)
    {
        System.out.println("通知之开始");
        Object retmsg = null;
        String birthString = null;
        List<Object> birth = new ArrayList<Object>();
        try
        {
            retmsg = joinPoint.proceed();
            if (retmsg != null)
            {
                if (retmsg instanceof java.util.List)
                {
                    List<Object> list = (List<Object>)retmsg;
                    for (Object object : list)
                    {
                        if (object instanceof String)
                        {
                            String reString = (String)object;
                            birthString = reString + "格式已经被转换";
                            birth.add(birthString);
                        }
                    }
                    
                }
                
            }
        }
        catch (Throwable e)
        {
            e.printStackTrace();
        }
        
        System.out.println("通知结束");
        return birth;
    }
    
    @After("annotationPointCut()")
    public void after()
    {
        System.out.println("after方法执行后");
    }
}
