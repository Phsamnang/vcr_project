package com.vcr.vcr_project.exception;

import org.springframework.http.HttpStatus;

public class BusinessException extends RuntimeException{
  private Object body;
  private HttpStatus code;

    public BusinessException( HttpStatus code,Object body) {
        this.body = body;
        this.code = code;
    }
}
