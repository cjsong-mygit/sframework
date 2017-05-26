package murong.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by murong on 2017/4/28.
 */
@Aspect
public class Aop {
    //定义切点
    @Pointcut("execution(** murong.aop.Performance.performance(..))")
    public void performance(){};

    //方法一：
    @Before("performance()")
    public void silenceCellPhones(){
        System.out.println("Silencing cell phone");
    }
    @Before("performance()")
    public void takeSeats(){
        System.out.println("Taking seats");
    }
    @AfterReturning("performance()")
    public void applause(){
        System.out.println("CLAP CLAP CLAP!!!");
    }
    @AfterThrowing("performance()")
    public void demandRefund(){
        System.out.println("Demanding a refund");
    }

    //方法二：
    //环绕
    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint jp){
        try{
            System.out.println("Silencing cell phone");
            System.out.println("Taking seats");
            jp.proceed();
            System.out.println("CLAP CLAP CLAP!!!");
        }catch(Throwable e){
            System.out.println("Demanding a refund");
        }
    }
}
