package com.example.ofc.feign;

import org.springframework.web.client.RestClientException;

import feign.Response;
import feign.RetryableException;
import feign.codec.ErrorDecoder;

public class MyErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        RestClientException cause = new RestClientException(response.toString());

        final int status = response.status();
        if (status == 503 || status == 504 || status == 404) {
            return new RetryableException(methodKey, cause, null);
        }
        return cause;
    }

}
