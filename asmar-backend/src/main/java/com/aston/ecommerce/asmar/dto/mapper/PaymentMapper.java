package com.aston.ecommerce.asmar.dto.mapper;

import com.aston.ecommerce.asmar.dto.PaymentDTO;
import com.aston.ecommerce.asmar.entity.Payment;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    PaymentDTO toPaymentDto(Payment payment);
    List<PaymentDTO> toPaymentDtos(List<Payment> payments);

    Payment toPayment(PaymentDTO paymentDTO);
    List<Payment> toPayments(List<PaymentDTO> paymentDTOS);
}
