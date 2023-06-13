package com.vcr.vcr_project.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Response<T> {
    private T payload;
    private String message;
    private HttpStatus status;
}
