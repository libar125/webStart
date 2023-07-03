package com.qing.fapi.abnormal;

import com.qing.common.ResponseModel;
import com.qing.common.ResultCodeEnum;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

/**
 * @author ME
 * @version 1.0.0
 * @Description TODO
 * @createTime 2022年09月07日 14:18:00
 */

@RestControllerAdvice
@Log4j2
public class Allabnormal {
    /***
     * 数据库操作异常-统一拦截处理 - 未能生效
     * @param e
     * @return
     */
    @ExceptionHandler(SQLException.class)
    public ResponseModel handlerSQLException(SQLException e) {
        log.error("SQL异常信息:"+e.getMessage(), e);
        return ResponseModel.error(ResultCodeEnum.FAIL, "数据操作失败！请联系管理员");
    }
    @ExceptionHandler(Exception.class)
    public ResponseModel handleException(Exception e)
    {
        log.error(e.getMessage(), e);
        return handlerOtherException( e ) ;
    }

    public ResponseModel handlerOtherException( Exception e ){
        if( e.getCause().toString().startsWith( "java.sql.SQL" ) ){
            return ResponseModel.error(ResultCodeEnum.FAIL, "数据操作失败！请联系管理员");
        }else{
            return ResponseModel.error(e.getMessage());
        }
    }

}