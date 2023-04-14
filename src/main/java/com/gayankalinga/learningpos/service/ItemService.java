package com.gayankalinga.learningpos.service;

import com.gayankalinga.learningpos.dto.ItemDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {
    String saveItem(ItemDto itemDto);

    List<ItemDto> getAllItems();
}
