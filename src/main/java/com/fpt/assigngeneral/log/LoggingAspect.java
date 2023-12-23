// package com.fpt.assigngeneral.log;

// import org.aspectj.lang.JoinPoint;
// import org.aspectj.lang.annotation.After;
// import org.aspectj.lang.annotation.AfterThrowing;
// import org.aspectj.lang.annotation.Aspect;
// import org.aspectj.lang.annotation.Before;
// import org.aspectj.lang.annotation.Pointcut;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.stereotype.Component;

// /**
//  * Lớp `LoggingAspect` là một Aspect trong Spring AOP được sử dụng để ghi log
//  * trước và sau khi gọi các phương thức trong `com.fpt.api.KhachHangAPI`.
//  */
// @Component
// @Aspect
// public class LoggingAspect {

// 	private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

// 	/**
// 	 * Điểm cắt (pointcut) cho các phương thức trong `com.fpt.api.KhachHangAPI`.
// 	 */
// 	@Pointcut("execution(* com.fpt.api.KhachHangAPI.*(..))")
// 	private void khachHangAPIPointcut() {
// 	}

// 	/**
// 	 * Log trước khi một phương thức được gọi.
// 	 *
// 	 * @param joinPoint Tham số JoinPoint chứa thông tin về việc gọi phương thức.
// 	 */
// 	@Before("khachHangAPIPointcut()")
// 	public void logBefore(JoinPoint joinPoint) {
// 		String methodName = joinPoint.getSignature().getName();
// 		logger.info("Call method " + methodName);
// 	}

// 	/**
// 	 * Log sau khi một phương thức đã hoàn thành.
// 	 *
// 	 * @param joinPoint Tham số JoinPoint chứa thông tin về việc gọi phương thức.
// 	 */
// 	@After("khachHangAPIPointcut()")
// 	public void logAfter(JoinPoint joinPoint) {
// 		String methodName = joinPoint.getSignature().getName();
// 		logger.info("Finish method " + methodName);
// 	}

// 	@AfterThrowing(pointcut = "khachHangAPIPointcut()", throwing = "exception")
// 	public void logException(JoinPoint joinPoint, Exception exception) {
// 		String method = joinPoint.getSignature().getName();
// 		logger.error("Exception at " + method + ": " + exception.getMessage());
// 	}

// 	@Pointcut("execution(* com.fpt.controller.admin.ListController.*(..))")
// 	private void listControllerLoggingAspect() {
// 	}

// 	@Before(value = "listControllerLoggingAspect()")
// 	public void logBeforeList(JoinPoint point) {
// 		String methodName = point.getSignature().getName();
// 		logger.info("Call method " + methodName);
// 	}

// 	@After(value = "listControllerLoggingAspect()")
// 	public void logAfterList(JoinPoint point) {
// 		String method = point.getSignature().getName();
// 		logger.info("Finish method " + method);
// 	}

// 	@AfterThrowing(pointcut = "listControllerLoggingAspect()", throwing = "exception")
// 	public void logWhenThrowException(JoinPoint point, Exception exception) {
// 		String method = point.getSignature().getName();
// 		logger.error("Exception in method " + method + ": " + exception.getMessage());
// 		logger.error("Exception Stack Trace: ", exception);
// 	}

// }
