package com.kingJava.demo.controller;

import com.kingJava.demo.dto.request.ItemSaveRequestDTO;
import com.kingJava.demo.dto.response.ItemGetResponseDTO;
import com.kingJava.demo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {
@Autowired
ItemService itemService;


@PostMapping("/save")
    public String itemSave(@RequestBody ItemSaveRequestDTO item){
    String saved = itemService.saveItem(item);
    return saved;
}

@GetMapping(path = "get-item-by-name", params = "name")
    public List<ItemGetResponseDTO> getItemByNameAndStatus(@RequestParam (value = "name") String itemName){
    List<ItemGetResponseDTO> items = itemService.getItemByNameAndStatus(itemName);

    return items;
}

    @GetMapping(path = "get-item-by-name-with-mapstruct", params = "name")
    public List<ItemGetResponseDTO> getItemByNameAndStatusByMapstruct(@RequestParam (value = "name") String itemName){
        List<ItemGetResponseDTO> items = itemService.getItemByNameAndStatusByMapstruct(itemName);

        return items;
    }

}
