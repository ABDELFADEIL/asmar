package com.aston.ecommerce.asmar.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class ShippingInfoServiceImpl {
}
