package com.driverlesscar.exception;

/**
 * Copyright
 * User: Ganzf
 * Date: 2019/7/29
 * Description: 超出范围异常
 */
public class OutOfAreaException extends Exception {
    public OutOfAreaException(String errorMsg) {
        super(errorMsg);
    }
}
