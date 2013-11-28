package com.cframe.framework.components.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class ServiceLogging {
	static final Logger log = LoggerFactory.getLogger(ServiceLogging.class);
	
	@Before("execution(* com.cframe.framework.components.*.web.*.*(..))")
	public void doBeforeLog(JoinPoint joinPoint) {
		log.info(joinPoint.getTarget().getClass().getName()+" "+joinPoint.getSignature().getName() +" Start");
	}
	
	@After("execution(* com.cframe.framework.components.*.web.*.*(..))")
	public void doAfterLog(JoinPoint joinPoint) {
		log.info(joinPoint.getTarget().getClass().getName()+" "+joinPoint.getSignature().getName() +" End");
	}
}