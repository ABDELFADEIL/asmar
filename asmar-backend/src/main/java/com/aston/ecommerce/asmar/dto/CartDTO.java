package com.aston.ecommerce.asmar.dto;

import java.time.LocalDate;
import java.util.List;

public class CartDTO {

    private Long id;
    private List<CommandLineDTO> commandLines;
    private boolean cartStatus;
    private UserDTO user;
    private LocalDate createDate;
    private float totalPrice;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CommandLineDTO> getCommandLines() {
        return commandLines;
    }

    public void setCommandLines(List<CommandLineDTO> commandLines) {
        this.commandLines = commandLines;
    }

    public boolean isCartStatus() {
        return cartStatus;
    }

    public void setCartStatus(boolean cartStatus) {
        this.cartStatus = cartStatus;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }
}
