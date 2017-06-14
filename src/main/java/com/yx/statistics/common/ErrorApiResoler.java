package com.yx.statistics.common;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.alibaba.fastjson.JSONObject;

//接口出现异常的，拦截返回异常信息
@ControllerAdvice(basePackages="com.yx.statistics.api")
public class ErrorApiResoler extends ResponseEntityExceptionHandler {
	private static final Logger LOG=Logger.getLogger(ErrorApiResoler.class);

    
	@ExceptionHandler
    @ResponseBody
    ResponseEntity<String> handleControllerException(HttpServletRequest request, Throwable ex) {
        HttpStatus status = getStatus(request);
        String errorMsg=ex.getMessage()==null ? "NullPointerException": ex.getMessage();
        Map<String, Object> map=new HashMap<String, Object>();
        map.put("status", Integer.parseInt(status.toString()));
        map.put("errorMsg", errorMsg);
        LOG.error(ex.toString());
        ResponseEntity<String> entity=new ResponseEntity<String>(JSONObject.toJSONString(map), HttpStatus.valueOf(200));
        return entity;
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
    private  String getExceptionStack(Throwable ex){
	    //at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        String errorMsg=ex.getMessage()==null ? ex.toString() : ex.getMessage();
        StackTraceElement[] stackElements=ex.getStackTrace();
	    StringBuilder sb=new StringBuilder();
        if (stackElements != null) {
            for (int i = 0; i < stackElements.length; i++) {
                if(i==0){
                    //com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Duplicate entry 'pDegBxJNmIJ7l2x0RVo7kXpiPgBU-oDegBxIVPXdVbrmICOPcVo2w29Vw' for key 'unique_card_person'
                    sb.append("\n"+stackElements[i].getClassName()+":\t"+errorMsg+"LineNumber:"+stackElements[i].getLineNumber());
                }else{
                    //at javax.servlet.http.HttpServlet.service(HttpServlet.java:648)
                    sb.append(String.format("\n\t at %s(%s %s: %d)",
                            stackElements[i].getClassName(),
                            stackElements[i].getFileName(),
                            stackElements[i].getMethodName(),
                            stackElements[i].getLineNumber()
                    ));
                    /*sb.append("\tat "+stackElements[i].getClassName()+"\t");
                    sb.append("("+stackElements[i].getFileName()+"\t");
                    sb.append(stackElements[i].getLineNumber()+"\t");
                    sb.append(stackElements[i].getMethodName()+"\n");*/
                }
            }
        }
        return sb.toString();
    }

}
