package com.masoud.hr.exception;


public class EmployeeDuplicateException extends Exception{
    public EmployeeDuplicateException() {
    }

    public EmployeeDuplicateException(String message) {
        super(message);
    }

    public EmployeeDuplicateException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeDuplicateException(Throwable cause) {
        super(cause);
    }

    public EmployeeDuplicateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
