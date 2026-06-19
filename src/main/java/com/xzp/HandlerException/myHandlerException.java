package com.xzp.HandlerException;

import com.xzp.Pojo.ResopnseResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class myHandlerException {
    @ExceptionHandler({NullPointerException.class,ArithmeticException.class,RuntimeException.class})
    public ResopnseResult<String> handlerException(Exception ex){
        String msg=ex.getMessage();
        ResopnseResult<String> responseResult=new ResopnseResult<>(400,msg);
        return  responseResult;
    }
}
