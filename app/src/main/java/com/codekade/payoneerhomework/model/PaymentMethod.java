package com.codekade.payoneerhomework.model;

public class PaymentMethod {

    String paymentName;
    String paymentLogoString;


    public PaymentMethod(String paymentName, String paymentLogoString) {
        this.paymentName = paymentName;
        this.paymentLogoString = paymentLogoString;
    }


    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }

    public String getPaymentLogoString() {
        return paymentLogoString;
    }

    public void setPaymentLogoString(String paymentLogoString) {
        this.paymentLogoString = paymentLogoString;
    }
}
