package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import util.Log;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@Component
@Aspect
public class TestAnnotationAspect {  
  
    @Pointcut("execution(* service.*.*(..))")
    private void pointCutMethod() {  
    }  
  

    //声明后置通知
    @AfterReturning(pointcut = "pointCutMethod()", returning = "result")
    public void doAfterReturning(JoinPoint jp, String result) {
        System.out.println("doAfterReturning:" + jp.getTarget().getClass().getName() + "." + jp.getSignature().getName()+"result:"+result);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式

        Log.writeLog("时间："+df.format(new Date())+",登录用户名："+ jp.getArgs()[0]+",密码："+jp.getArgs()[1]+",登录"+result);

    }
}  