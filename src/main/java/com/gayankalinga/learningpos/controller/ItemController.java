package com.gayankalinga.learningpos.controller;

import com.gayankalinga.learningpos.dto.ItemDto;
import com.gayankalinga.learningpos.service.ItemService;
import com.gayankalinga.learningpos.util.StandardResponse;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/item")
@CrossOrigin
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> saveItem(@RequestBody ItemDto itemDto){
        String saveResponse = itemService.saveItem(itemDto);

        ResponseEntity<StandardResponse> responseEntity = new ResponseEntity<StandardResponse>(
            new StandardResponse(201, "Creation Success", saveResponse),
                HttpStatus.CREATED
        );

        return responseEntity;
    }

    @GetMapping(path = "get/all")
    public ResponseEntity<StandardResponse> getAllItems(){
        List<ItemDto> itemDtoList = itemService.getAllItems();

        ResponseEntity<StandardResponse> standardResponse = new ResponseEntity<>(
                new StandardResponse(200, "Items Found", itemDtoList),
                HttpStatus.OK
        );

        return standardResponse;
    }
}
