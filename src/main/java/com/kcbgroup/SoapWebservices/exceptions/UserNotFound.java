package com.kcbgroup.SoapWebservices.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.CLIENT)
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFound extends RuntimeException{
    public UserNotFound(String message) {
        super(message);
    }
}
