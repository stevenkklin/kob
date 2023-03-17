package com.kob.backend.exception;

import com.kob.backend.common.util.R;
import lombok.extern.slf4j.Slf4j;
//import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Steven
 * @create 2022-12-11-14:25
 */
@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {
    @ResponseBody
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public R validExceptionHandler(Exception e){
        log.error("执行异常",e);
        if (e instanceof MethodArgumentNotValidException){
            MethodArgumentNotValidException ex = (MethodArgumentNotValidException)e;
            //将错误信息放回给前台
             return R.error(ex.getBindingResult().getFieldError().getDefaultMessage()) ;
        }else if(e instanceof KOBException){
            KOBException ex = (KOBException)e;
            return R.error(ex.getMsg());
        }
        else if (e instanceof BadCredentialsException){
            return R.error(e.getMessage());
        }
        else{
            return R.error("后端执行异常");
        }
    }

}
