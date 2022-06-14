package com.aston.ecommerce.asmar.dto.mapper;

import com.aston.ecommerce.asmar.dto.ShippingInfoDTO;
import com.aston.ecommerce.asmar.entity.ShippingInfo;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ShippingInfoMapper {

    ShippingInfoDTO toShippingInfoDto(ShippingInfo shippingInfo);
    List<ShippingInfoDTO> toShippingInfoDtos(List<ShippingInfo> shippingInfos);

    ShippingInfo toShippingInfo(ShippingInfoDTO shippingDTO);
    List<ShippingInfo> toShippingInfos(List<ShippingInfoDTO> shippingInfoDTOS);
}
