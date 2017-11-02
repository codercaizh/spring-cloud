package com.czh.contacts.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.czh.contacts.entity.Response;

/**
 * 通用异常处理器
 * @author caizh
 *
 */
@ControllerAdvice
@RestController
public class CommonExceptionHandler {
   
   private static final Logger logger = LoggerFactory.getLogger(CommonExceptionHandler.class);
   
   /**
    * 接收所有异常信息，并封装为统一的返回体
    * @param e
    * @return
    */
   @ExceptionHandler
   public Response handlerException(Exception e) {
	   logger.error(e.getMessage(),e);
	   Response response = new Response();
	   response.setRtncode(Response.FAILED);
	   response.setMessage("系统出现异常，异常原因：" + e.getMessage());
       return response;  
   }  
}
