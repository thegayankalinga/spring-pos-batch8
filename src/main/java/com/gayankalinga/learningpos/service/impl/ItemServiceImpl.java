package com.gayankalinga.learningpos.service.impl;

import com.gayankalinga.learningpos.dto.ItemDto;
import com.gayankalinga.learningpos.entity.Item;
import com.gayankalinga.learningpos.repository.ItemRepository;
import com.gayankalinga.learningpos.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public String saveItem(ItemDto itemDto) {
        Item item = new Item();
        itemDtoToItemEntity(itemDto, item);
        itemRepository.save(item);
        return itemDto + " Saved Successfully";
    }

    private static void itemDtoToItemEntity(ItemDto itemDto, Item item) {
        item.setItemName(itemDto.itemName());
        item.setItemQty(itemDto.itemQty());
        item.setQuantityType(itemDto.quantityType());
        item.setSellerPrice(itemDto.sellerPrice());
        item.setPurchasedPrice(itemDto.purchasedPrice());
        item.setStatus(itemDto.status());
    }
}
