package com.comp5703.yearnmove.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    private Integer code;
    private String message;
    private T data;

    public static <T> Result<T> success(T object, String message) {
        Result<T> r = new Result<T>();
        r.data = object;
        r.code = 20000;
        r.message = message;
        return r;
    }

    public static <T> Result<T> error(String message) {
        Result r = new Result();
        r.message = message;
        r.code = 50000;
        return r;
    }

    public static <T> Result<T> error(T object, String message) {
        Result<T> r = new Result<T>();
        r.data = object;
        r.code = 50000;
        r.message = message;
        return r;
    }
}

