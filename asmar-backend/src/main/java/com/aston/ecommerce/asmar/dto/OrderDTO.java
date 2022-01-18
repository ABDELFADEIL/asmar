package com.aston.ecommerce.asmar.dto;

import java.time.LocalDate;
import java.util.List;


public class OrderDTO {

    private Long id;
    private String deliveryStatus;
    private LocalDate orderDate;
    private LocalDate shippingDate;
    private float deliveryPrice;
    private float total;
    private List<CommandLineDTO> commandLineList;
    private UserDTO userDTO;
    private AddressDTO addressDTO;
    private PaymentDTO paymentDTO;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
    }

    public float getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(float deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public List<CommandLineDTO> getCommandLineList() {
        return commandLineList;
    }

    public void setCommandLineList(List<CommandLineDTO> commandLineList) {
        this.commandLineList = commandLineList;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    public void setAddressDTO(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }

    public PaymentDTO getPaymentDTO() {
        return paymentDTO;
    }

    public void setPaymentDTO(PaymentDTO paymentDTO) {
        this.paymentDTO = paymentDTO;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "id=" + id +
                ", deliveryStatus='" + deliveryStatus + '\'' +
                ", orderDate=" + orderDate +
                ", shippingDate=" + shippingDate +
                ", deliveryPrice=" + deliveryPrice +
                ", total=" + total +
                ", commandLineList=" + commandLineList +
                ", userDTO=" + userDTO +
                ", addressDTO=" + addressDTO +
                ", paymentDTO=" + paymentDTO +
                '}';
    }
}
