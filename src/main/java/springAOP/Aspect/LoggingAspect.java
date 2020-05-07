package springAOP.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

//@Aspect
public class LoggingAspect {
    //@Before("execution(public String getName())")
    //@Before("execution(public String springAOP.Model.Circle.getName())")
    //@Before("execution(public * get*())")
    //@Before("execution(public String springAOP.Model.*.get*())")
    //@Before("execution(public * get*(..))")
    /*  @Before("allGetters() && allCircleMethod() ")
      public void loggingAdvice(JoinPoint joinPoint){
        System.out.println("Advice run.get method called");
          System.out.println(joinPoint.toString());
      }*/
     // @Before("args(name)")
      //@After("args(name)")
    /*  @AfterReturning(pointcut = "args(name)",returning = "returnString")
      public void stringArgumentMethods(String name,Object returnString){
          System.out.println("A method that takes string argumentshas been called. The value is " + name + " the output is " + returnString);
      }
      @AfterThrowing(pointcut = "args(name)",throwing = "ex")
      public void exceptionAdvice(String name , RuntimeException ex){
          System.out.println("An exception has been thrown" + ex);
      }*/
    //  @Around("allGetter()")
      public Object myAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
          Object returnValue = null;
          try{
              System.out.println("Before Advice");
              returnValue =  proceedingJoinPoint.proceed();
              System.out.println("After Advice");
          }
          catch (Throwable e){
              System.out.println("After Throwing");
          }
          System.out.println("after Finally");
          return returnValue;
      }
         public void loggingAdvice(){
             System.out.println("logging from the advice");
         }
    /*  @Before("allGetters() ")
      public void secondAdvice(){
          System.out.println("second advice executed");
      }*/
    /* @Pointcut("execution(* get*())")
      public void allGetters(){}
     */

     /* @Pointcut("within(springAOP.Model.Circle)")
      public void allCircleMethod(){

      }*/
}
