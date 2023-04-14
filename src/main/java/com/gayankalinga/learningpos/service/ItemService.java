package com.gayankalinga.learningpos.service;

import com.gayankalinga.learningpos.dto.ItemDto;
import org.springframework.stereotype.Service;

@Service
public interface ItemService {
    String saveItem(ItemDto itemDto);
}
