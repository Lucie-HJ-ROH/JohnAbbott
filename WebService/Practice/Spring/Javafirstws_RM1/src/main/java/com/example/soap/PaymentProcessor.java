package com.example.soap;

import com.example.soap.dto.PaymentProcessorRequest;
import com.example.soap.dto.PaymentProcessorResponse;
import com.example.soap.exceptions.ServiceException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(name = "PaymentProcessor")
public interface PaymentProcessor {

    @WebMethod
    public @WebResult(name="response") PaymentProcessorResponse processPayment(
            @WebParam(name = "paymentProcessorRequest") PaymentProcessorRequest paymentProcessorRequest) throws ServiceException;
}
