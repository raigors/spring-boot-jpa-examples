package com.github.spring.boot.jpa.common.pojo.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 接口层统一返回对象
 * <p>
 * create in 2021/2/23 5:14 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Getter
@Setter
@Builder
@ToString
@SuppressWarnings("unused")
public class ResultVO<T extends Serializable> implements Serializable {

    private static final long serialVersionUID = -1095916834410197538L;

    private Integer status;

    private String message;

    private T data;

    public static <T extends Serializable> ResultVO<T> success() {
        return ResultVO.<T>builder().status(200).message("执行成功").build();
    }

    public static <T extends Serializable> ResultVO<T> success(String message) {
        return ResultVO.<T>builder().message(message).status(200).build();
    }

    public static <T extends Serializable> ResultVO<T> success(String message, T data) {
        return ResultVO.<T>builder().status(200).message(message).data(data).build();
    }

    public static <T extends Serializable> ResultVO<T> success(T data) {
        return ResultVO.<T>builder().status(200).message("执行成功").data(data).build();
    }

    public static <T extends Serializable> ResultVO<T> failure() {
        return ResultVO.<T>builder().status(500).message("执行失败").build();
    }

    public static <T extends Serializable> ResultVO<T> failure(String message) {
        return ResultVO.<T>builder().status(500).message(message).build();
    }

    public static <T extends Serializable> ResultVO<T> failure(String message, T data) {
        return ResultVO.<T>builder().status(500).message(message).data(data).build();
    }

    public static <T extends Serializable> ResultVO<T> failure(T data) {
        return ResultVO.<T>builder().status(500).message("执行失败").data(data).build();
    }

}
