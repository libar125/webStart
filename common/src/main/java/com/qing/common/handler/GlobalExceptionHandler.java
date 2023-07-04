package com.qing.common.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * @description: 自定义异常处理
 * @author: DT
 * @date: 2021/4/19 21:51
 * @version: v1.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private final static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);



//    /**
//     * 处理其他异常
//     * @param e
//     * @return
//     */
//    @ExceptionHandler(value =Exception.class)
//    @ResponseBody
//    public ResponseModel exceptionHandler(Exception e){
//        logger.error("未知异常！原因是:",e.toString());
//        return ResponseModel.error(e.getMessage());
//    }

//    /**
//     * 处理运行时异常
//     * @param e
//     * @return
//     */
//    @ExceptionHandler(value =RuntimeException.class)
//    @ResponseBody
//    public ResponseModel runtimeExceptionHandler(RuntimeException e){
//        logger.error("运行时异常！原因是:",e.toString());
//        return ResponseModel.error(e.getMessage());
//    }
}

