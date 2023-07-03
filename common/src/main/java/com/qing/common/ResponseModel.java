package com.qing.common;

import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
public class ResponseModel<T> {

    private int code = 0;
    private String message = "";
    private T data;

    public static <T> ResponseModel<T> success() {
        return getResponse(ResultCodeEnum.SUCCESS, null);
    }

    public static <T> ResponseModel<T> success(T data) {
        return getResponse(ResultCodeEnum.SUCCESS, data);
    }

    public static <T> ResponseModel<T> error() {
        return getResponse(ResultCodeEnum.FAIL, null);
    }

    public static <T> ResponseModel<T> error(ResultCodeEnum codeEnum) {
        return getResponse(codeEnum, null);
    }

    public static <T> ResponseModel<T> error(T data) {
        return getResponse(ResultCodeEnum.FAIL, data);
    }

    public static <T> ResponseModel<T> error(ResultCodeEnum codeEnum, T data) {
        return getResponse(codeEnum, data);
    }

    public static <T> ResponseModel<T> error(int code, String message) {
        return getResponse(code, message);
    }


    public static <T> ResponseModel<T> error(int code, String message, T data) {
        return getResponse(code, message, data);
    }

    private static <T> ResponseModel<T> getResponse(int codes, String message) {
        ResponseModel responseModel = new ResponseModel<T>();
        responseModel.setCode(codes);
        responseModel.setMessage(message);
        return responseModel;
    }

    private static <T> ResponseModel<T> getResponse(int codes, String message, T data) {
        ResponseModel responseModel = new ResponseModel<T>();
        responseModel.setCode(codes);
        responseModel.setMessage(message);
        responseModel.setData(data);
        return responseModel;
    }


    public static <T> ResponseModel<T> getResponse(ResultCodeEnum codes, T data) {
        ResponseModel responseModel = new ResponseModel<T>();
        responseModel.setCode(codes.code());
        responseModel.setMessage(codes.message());
        responseModel.setData(data);
        return responseModel;
    }

}
