package com.codekade.payoneerhomework.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class PaymentMethodTest {

    String paymentName;
    String paymentLogoString;

    @Test
    public void getPaymentName() {

        PaymentMethod paymentMethod = new PaymentMethod("American Express", "https://resources.integration.oscato.com/resource/network/MOBILETEAM/en_US/AMEX/logo3x.png");
        assertEquals("American Express", paymentMethod.getPaymentName());
    }

    @Test
    public void setPaymentName() {
        PaymentMethod paymentMethod = new PaymentMethod("American Express", "https://resources.integration.oscato.com/resource/network/MOBILETEAM/en_US/AMEX/logo3x.png");
        paymentMethod.setPaymentName("Mastercard");
        assertEquals("Mastercard", paymentMethod.getPaymentName());

    }

    @Test
    public void getPaymentLogoString() {
        PaymentMethod paymentMethod = new PaymentMethod("American Express", "https://resources.integration.oscato.com/resource/network/MOBILETEAM/en_US/AMEX/logo3x.png");
        assertEquals("https://resources.integration.oscato.com/resource/network/MOBILETEAM/en_US/AMEX/logo3x.png", paymentMethod.getPaymentLogoString());
    }

    @Test
    public void setPaymentLogoString() {
        PaymentMethod paymentMethod = new PaymentMethod("American Express", "https://resources.integration.oscato.com/resource/network/MOBILETEAM/en_US/AMEX/logo3x.png");
        paymentMethod.setPaymentLogoString("https://resources.integration.oscato.com/resource/network/MOBILETEAM/en_US/MASTERCARD/logo3x.png");
        assertEquals("https://resources.integration.oscato.com/resource/network/MOBILETEAM/en_US/MASTERCARD/logo3x.png", paymentMethod.getPaymentLogoString());
    }

}