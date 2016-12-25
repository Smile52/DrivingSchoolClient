package com.yoflying.drivingschool.bean;

/**
 * Created by yaojiulong on 2016/12/23.
 */

public class HttpsResult<T> {
    private int status;
    private String message;
    private int pageNum;
    private int total;
    private T data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "HttpsResult{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", pageNum=" + pageNum +
                ", total=" + total +
                ", data=" + data +
                '}';
    }
}
