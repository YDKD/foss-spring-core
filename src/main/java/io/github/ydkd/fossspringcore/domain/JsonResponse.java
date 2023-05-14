package io.github.ydkd.fossspringcore.domain;

import org.springframework.http.HttpStatus;

public class JsonResponse<T> {

    private Integer status;

    private String msg;

    private T data;

    public JsonResponse(HttpStatus status, String msg) {
        this.status = status.value();
        this.msg = msg;
    }

    public JsonResponse(T data) {
        this.data = data;
        this.status = HttpStatus.OK.value();
        this.msg = "成功";
    }


    public JsonResponse(T data, HttpStatus status, String msg) {
        this.data = data;
        this.status = status.value();
        this.msg = msg;
    }

    public JsonResponse(Integer errorCode, String errorMsg) {
        this.msg = errorMsg;
        this.status = errorCode;
        this.data = null;
    }

    public JsonResponse<T> success(T data) {
        return new JsonResponse<T>(data);
    }

    public static JsonResponse<String> success() {
        return  new JsonResponse<>(HttpStatus.OK, "成功!");
    }

    public static JsonResponse<String> success(Integer status) {
        return new JsonResponse<>(null);
    }

    public static JsonResponse<String> success(String msg) {
        return new JsonResponse<>(msg);
    }

    public static JsonResponse<String> fail() {
        return new JsonResponse<>(HttpStatus.PRECONDITION_FAILED, "失败");
    }

    public static JsonResponse<String> fail(Integer status, String msg) {
        return new JsonResponse<>(HttpStatus.PRECONDITION_FAILED, msg);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
