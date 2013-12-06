package com.cframe.framework.components.logging;

import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cframe.framework.core.util.SecurityUtility;

@Aspect
public class ServiceLogging {
	static final Logger log = LoggerFactory.getLogger(ServiceLogging.class);
	
	private Long processingTime;
	
	@Before("execution(* com.cframe.framework.components.*.web.*.*(..))")
	public void doBeforeLog(JoinPoint joinPoint) {
		processingTime = System.nanoTime();
		log.info(joinPoint.getTarget().getClass().getName()+" "+joinPoint.getSignature().getName() +" S ");
	}
	
	@After("execution(* com.cframe.framework.components.*.web.*.*(..))")
	public void doAfterLog(JoinPoint joinPoint) {
		Long ime = System.nanoTime() - this.processingTime;
		Map<String, Object> data = SecurityUtility.getLoginDetailMap();
		if(data != null){
			log.info(joinPoint.getTarget().getClass().getName()+" "+joinPoint.getSignature().getName() + " E " + ime + " " + data.get("id") + " " + data.get("birthyear") + 
					" " + data.get("birthmonth") + " " + data.get("birthday") + " " + data.get("sex") + " " + data.get("contrycode") + " " + data.get("emaillast"));
		}else{
			log.info(joinPoint.getTarget().getClass().getName()+" "+joinPoint.getSignature().getName() +" E " + "Nothing");	
		}
	}
}