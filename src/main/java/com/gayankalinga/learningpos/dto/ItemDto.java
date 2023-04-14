package com.gayankalinga.learningpos.dto;

import com.gayankalinga.learningpos.enumz.QuantityType;

public record ItemDto(
        java.lang.String itemName,
        int itemQty,
        QuantityType quantityType,
        double sellerPrice,
        double purchasedPrice,
        boolean status) {

}
