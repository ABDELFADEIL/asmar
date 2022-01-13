package com.aston.ecommerce.asmar.dto.mapper;

import com.aston.ecommerce.asmar.dto.OrderDTO;
import com.aston.ecommerce.asmar.dto.PaymentDTO;
import com.aston.ecommerce.asmar.entity.Order;
import com.aston.ecommerce.asmar.entity.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    public static final PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);
    PaymentDTO toPaymentDto(Payment payment);
    List<PaymentDTO> toPaymentDtos(List<Payment> payments);

    Payment toPayment(PaymentDTO paymentDTO);
    List<Payment> toPayments(List<PaymentDTO> paymentDTOS);
}
