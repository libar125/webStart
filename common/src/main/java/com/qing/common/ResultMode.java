package com.qing.common;

import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * @description 统一返回对象
 * @date 2023-08-30 上午 09:47
 * @author libar
 */
@Data
public class ResultMode<T> {

    /**
     * 状态标识
     */
    private Integer code;
    /**
     * 返回信息
     */
    private String msg;
    /**
     * 返回数据
     */
    private T data;

    /**
     * 是否出错
     * @return	true or false
     */
    public boolean isError() {
        return code != HttpStatus.OK.value();
    }



    public static ResultMode success() {
        ResultMode result = new ResultMode();
        result.setCode(ResultCodeEnum.SUCCESS.getCode());
        return result;
    }

    public static <T> ResultMode<T> success(T data) {
        ResultMode<T> result = new ResultMode<>();
        result.setCode(ResultCodeEnum.SUCCESS.getCode());
        result.setData(data);
        return result;
    }

    public static ResultMode failure() {
        ResultMode result = new ResultMode();
        result.setCode(ResultCodeEnum.FAIL.getCode());
        result.setMsg("server error...");
        return result;
    }

    public static ResultMode failure(String msg) {
        ResultMode result = new ResultMode();
        result.setCode(ResultCodeEnum.FAIL.getCode());
        result.setMsg(msg);
        return result;
    }

}
