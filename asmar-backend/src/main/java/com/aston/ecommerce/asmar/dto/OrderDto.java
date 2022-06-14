package com.aston.ecommerce.asmar.dto;

import java.math.BigDecimal;

public class OrderDto {


    private String deliveryStatus;
    private BigDecimal deliveryPrice;
    private int [] commandLineListIds;
    private int userId;
    private int deliveryAddressId;
    private int billingAddressId;
    private int paymentId;

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public BigDecimal getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(BigDecimal deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public int[] getCommandLineListIds() {
        return commandLineListIds;
    }

    public void setCommandLineListIds(int[] commandLineListIds) {
        this.commandLineListIds = commandLineListIds;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getDeliveryAddressId() {
        return deliveryAddressId;
    }

    public void setDeliveryAddressId(int deliveryAddressId) {
        this.deliveryAddressId = deliveryAddressId;
    }

    public int getBillingAddressId() {
        return billingAddressId;
    }

    public void setBillingAddressId(int billingAddressId) {
        this.billingAddressId = billingAddressId;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }
}
