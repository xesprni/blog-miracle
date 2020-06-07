package com.miracle.config;


import com.miracle.model.BlogErrorCodeAndMsgEnum;
import com.miracle.model.ModelResult;
import com.miracle.model.ModelResultClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Miracle
 * @date 19:15 2019/7/14
 */
@ControllerAdvice
@RestController
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public ModelResult<String> exceptionHandler(Exception e) {
        e.printStackTrace();
        log.error("catch exception:", e);
        if (e instanceof MethodArgumentNotValidException) {
            return new ModelResultClient<String>().fail(BlogErrorCodeAndMsgEnum.PARAM_VALIDATE_ERROR.getCode(), BlogErrorCodeAndMsgEnum.PARAM_VALIDATE_ERROR.getMsg());
        } else {
            return new ModelResultClient<String>().fail(BlogErrorCodeAndMsgEnum.SERVER_ERROR.getCode(), e.getLocalizedMessage());
        }
    }
}
