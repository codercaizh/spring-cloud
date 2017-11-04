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
//该注解定义了该类为一个切面类
@Aspect
public class RequestHandlerLogging {
	
	private static final Logger logger = LoggerFactory.getLogger(RequestHandlerLogging.class);
	/**
	 * 记录所有控制器日志
	 */
	//@Pointcut注解定义了切入点，下面定义的意思是该切入点为com.czh.contacts.controller这个包下所有以Controller结尾的类中所有的方法（不限参数）
	@Pointcut("execution(* com.czh.contacts.controller.*Controller.*(..))")
    public void excudeController(){}
	
	//该注解定义了该方法为环绕通知
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
			//方法执行后的结果
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
