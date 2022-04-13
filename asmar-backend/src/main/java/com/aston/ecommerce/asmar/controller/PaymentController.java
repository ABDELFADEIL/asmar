package com.aston.ecommerce.asmar.controller;

import com.aston.ecommerce.asmar.config.stripe.dto.ConfirmPayment;
import com.aston.ecommerce.asmar.config.stripe.dto.CreatePaymentResponse;
import com.aston.ecommerce.asmar.config.stripe.model.CheckoutForm;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
public class PaymentController {


    @PostMapping("/create-payment-intent")
    public CreatePaymentResponse createPaymentIntent(@RequestBody @Valid CheckoutForm createPayment)throws StripeException {
        PaymentIntentCreateParams paymentIntentCreateParams = new PaymentIntentCreateParams.Builder()
                .setAmount(createPayment.getAmount() * 100L)
                .setCurrency("eur")
                .setReceiptEmail(createPayment.getEmail())
                .putMetadata("featureRequest", createPayment.getFeatureRequest())
                .build();
        PaymentIntent paymentIntent =
                PaymentIntent.create(paymentIntentCreateParams);
        System.out.println(paymentIntent.getClientSecret());
       return new CreatePaymentResponse(paymentIntent.getClientSecret());
    }

    @PostMapping("/confirm-payment-intent")
    public CreatePaymentResponse confirmPaymentIntent(@RequestBody @Valid ConfirmPayment confirmPayment)throws StripeException {
        // To create a PaymentIntent for confirmation, see our guide at: https://stripe.com/docs/payments/payment-intents/creating-payment-intents#creating-for-automatic
        PaymentIntent paymentIntent =
                PaymentIntent.retrieve(
                        confirmPayment.getPaymentId()
                );

        Map<String, Object> params = new HashMap<>();
        params.put("payment_method", "pm_card_visa");

        PaymentIntent updatedPaymentIntent =
                paymentIntent.confirm(params);
        return new CreatePaymentResponse(updatedPaymentIntent.getClientSecret());
    }
}
