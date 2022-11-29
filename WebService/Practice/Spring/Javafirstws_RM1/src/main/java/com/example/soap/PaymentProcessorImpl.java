package com.example.soap;

import com.example.soap.dto.PaymentProcessorRequest;
import com.example.soap.dto.PaymentProcessorResponse;
import com.example.soap.exceptions.ServiceException;

public class PaymentProcessorImpl implements PaymentProcessor{


    @Override
    public PaymentProcessorResponse processPayment(PaymentProcessorRequest paymentProcessorRequest) throws ServiceException {
        PaymentProcessorResponse paymentProcessorResponse = new PaymentProcessorResponse();

        if(paymentProcessorRequest.getCreditCardInfo().getCardNumber() == null
        || paymentProcessorRequest.getCreditCardInfo().getCardNumber().length() == 0) {
            throw new ServiceException("Invalid credit card Number");

        }

        //Business Logic or a call to a Business Logic Class
        paymentProcessorResponse.setResult(true);
        return paymentProcessorResponse;

    }
}
