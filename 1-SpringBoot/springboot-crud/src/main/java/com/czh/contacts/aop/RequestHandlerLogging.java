package com.czh.contacts.aop;

import java.util.Arrays;
import java.util.UUID;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 请求及响应日志记录
 * @author caizh
 *
 */
@Component
@Aspect
public class RequestHandlerLogging {
	
	private static final Logger logger = LoggerFactory.getLogger(RequestHandlerLogging.class);
	/**
	 * 记录所有控制器日志
	 */
	@Pointcut("execution(* com.czh.contacts.controller.*Controller.*(..))")
    public void excudeController(){}
	
	@Around("excudeController()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		//请求流水号
		String  serialNumber = UUID.randomUUID().toString().replaceAll("-", "");
		
		//传入的参数
		Object[] args = proceedingJoinPoint.getArgs();
		
		//请求开始时间
		Long startTime = System.currentTimeMillis();
		logger.info("控制器({})的方法({}) 接收到请求({}),请求参数:{}",proceedingJoinPoint.getTarget().getClass().getName(),
															proceedingJoinPoint.getSignature().getName(),
															serialNumber,
															Arrays.asList(args)
															);
		
		//处理结果
		Object result = null;
		try {
			result = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			logger.info("请求({})处理出现异常,异常原因:{}",serialNumber,e.getMessage());
			throw e;
		}
		
		//计算耗时
		Long processTime = System.currentTimeMillis() - startTime;
		logger.info("请求({})处理完成，总耗时：{}ms 返回结果:{}",serialNumber,processTime,result.toString());
        return result;
    }
}
