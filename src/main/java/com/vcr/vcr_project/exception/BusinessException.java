package com.vcr.vcr_project.exception;

import com.vcr.vcr_project.common.api.StatusCode;

/**
 * Handle exception for Business Exception
 */
public class BusinessException extends RuntimeException {
    private Object body;
    private final StatusCode errorCode;

    public BusinessException(StatusCode errorCode, Object body) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.body = body;
    }

    public BusinessException(StatusCode errorCode, String message) {

        super(message);
        this.errorCode = errorCode;

    }

    public BusinessException(StatusCode errorCode) {

        super(errorCode.getMessage());
        this.errorCode = errorCode;

    }

    public BusinessException(StatusCode errorCode, Throwable e) {

        this(errorCode);
//        AppLogManager.error(e);

    }

    public StatusCode getErrorCode() {
        return errorCode;
    }

    public Object getBody() {
        return body;
    }
}
