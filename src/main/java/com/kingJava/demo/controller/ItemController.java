package com.kingJava.demo.controller;

import com.kingJava.demo.dto.paginated.PaginatedResponseItemDTO;
import com.kingJava.demo.dto.request.ItemSaveRequestDTO;
import com.kingJava.demo.dto.response.ItemGetResponseDTO;
import com.kingJava.demo.service.ItemService;
import com.kingJava.demo.util.StanderdResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {
@Autowired
ItemService itemService;


//@PostMapping("/save")
//    public String itemSave(@RequestBody ItemSaveRequestDTO item){
//    String saved = itemService.saveItem(item);
//    return saved;
//}

    @PostMapping("/save")
    public ResponseEntity<StanderdResponse> itemSave(@RequestBody ItemSaveRequestDTO item){
        String saved = itemService.saveItem(item);
//        ResponseEntity<StanderdResponse> response = new ResponseEntity<StanderdResponse>(new StanderdResponse(201,"sucess",saved), HttpStatus.CREATED);
//        return response;
        return new ResponseEntity<StanderdResponse>(new StanderdResponse(201,"sucess",saved),HttpStatus.CREATED);
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

    @GetMapping(path="/get-all-item-by-status", params={"activeStatus","page","size"})
    public ResponseEntity<StanderdResponse> getItemsByActiveStatus(boolean activeStatus, int page, int size){
//        List<ItemGetResponseDTO> itemDTOs = itemService.getItemsByActiveStatus(activeStatus);

        PaginatedResponseItemDTO paginatedResponseItemDTO = itemService.getItemsByActiveStatusWithPagination(activeStatus,page,size);
        return new ResponseEntity<StanderdResponse>(new StanderdResponse(200,"sucess",paginatedResponseItemDTO),HttpStatus.OK);
    }

}
