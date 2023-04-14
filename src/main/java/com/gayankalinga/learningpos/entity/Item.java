package com.gayankalinga.learningpos.entity;


import com.gayankalinga.learningpos.enumz.QuantityType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "item")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    @Id
    @Column(name = "item_id", length = 50)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemId;

    @Column(name = "item_name", nullable = false)
    private String itemName;

    @Column(name = "item_qty")
    private int itemQty;

    @Column(name = "qty_type")
    private QuantityType quantityType;

    @Column(name = "seller_price")
    private double sellerPrice;

    @Column(name = "purchased_price")
    private double purchasedPrice;

    @Column(name = "status", columnDefinition = "TINYINT default 0")
    private boolean status;

}
