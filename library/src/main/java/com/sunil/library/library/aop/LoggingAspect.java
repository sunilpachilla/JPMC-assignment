package com.sunil.library.library.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	private final Logger log =  LoggerFactory.getLogger(this.getClass());
	
	
	@Before("execution(* com.sunil.library.library.controller.StudentController.saveStudent(..))")
	public void LogBeforeMethodCall(JoinPoint joinPoint) throws Throwable{
		
		log.info("Object is being saved " + joinPoint.getSignature().getName());//method name
		
	}

	@After("execution(* com.sunil.library.library.controller.StudentController.getStudents(..))")
	public void LogAfterMethodCall(JoinPoint joinPoint) throws Throwable{
		
		log.info("Got all the students " + joinPoint.getSignature().getName());//method name
		
	}
}
	
	/*//Point cut tat matches all repositories, services and web rest end points .
	@Pointcut("within(@org.springframework.stereotype.Repository *)" + 
	          " || within(@org.springframework.stereotype.Service *)" +
			" || within(@org.springframework.web.bind.annotation.RestController *)")
	public void springBeanPointcut() {
		//Medthos is empty as this is just a PointCut, the implement are in the advices
	}
	
	/*
	 * Advice that logs methods throwing exception
	 * @Param joinpoint join point for advice
	 * 
	 * @param e Exception
	 * */
	
	/*@AfterThrowing(pointcut="springBeanPointcut()",throwing = "e")
	public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
		
		log.info("errrrorrrrrrrrrrrrrrrrrrr occureddddddddddddddddddddddddddddd");
		
		/*log.error("Exception in {}.{}() with cause ={}",joinPoint.getSignature().getDeclaringTypeName(),
				joinPoint.getSignature().getName(),e.getCause()!=null?e.getCause():"NULL");*/
	

	

