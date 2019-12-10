package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Arrays;

public class TestAspect {  
	  
    public void doAfter(JoinPoint jp) {  
        System.out.println("doAfter: " + jp.getTarget().getClass().getName() + "." + jp.getSignature().getName());  
    }
  
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {  
        System.out.println("doAround-begin");
    	Object retVal = pjp.proceed();
        System.out.println("²ÎÊýÖµ"+ Arrays.toString(pjp.getArgs()));

        System.out.println("doAround-end");
        return retVal;  
    }  
  
    public void doBefore(JoinPoint jp) {  
        System.out.println("doBefore: " + jp.getTarget().getClass().getName() + "." + jp.getSignature().getName());  
    }  
  
    public void doThrowing(JoinPoint jp, Throwable ex) {  
        System.out.print("doThowing: " + jp.getTarget().getClass().getName() + "." + jp.getSignature().getName()+"  ");  
        System.out.println("error message:"+ex.getMessage());  
    }  
    public void doAfterReturning(JoinPoint jp,String result) {  
        System.out.println("doAfterReturning:" + jp.getTarget().getClass().getName() + "." + jp.getSignature().getName()+"result:"+result);  
    }  
}  
