package com.kingJava.demo.service.impl;

import com.kingJava.demo.dto.paginated.PaginatedResponseItemDTO;
import com.kingJava.demo.dto.request.ItemSaveRequestDTO;
import com.kingJava.demo.dto.response.ItemGetResponseDTO;
import com.kingJava.demo.entity.Item;
import com.kingJava.demo.exception.NotFoundException;
import com.kingJava.demo.repo.ItemRepo;
import com.kingJava.demo.service.ItemService;
import com.kingJava.demo.util.mappers.ItemMapper;
import jakarta.validation.constraints.Max;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceIMPL implements ItemService {
    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public String saveItem(ItemSaveRequestDTO itemSaveRequestDTO) {
//        Item item = new Item(
//                1,
//                itemSaveRequestDTO.getItemName(),
//                itemSaveRequestDTO.getMeasuringUnitType(),
//                itemSaveRequestDTO.getBalanceQty(),
//                itemSaveRequestDTO.getSupplierPrice(),
//                ite mSaveRequestDTO.getSellingPrice(),
//                true
//        );
//        itemRepo.save(item);
//        return item.getItemName()+" saved successfully!";
        Item item = modelMapper.map(itemSaveRequestDTO, Item.class);
       // item.setActive(true); if we want can use.
        if(!itemRepo.existsById(item.getItemId())){
            itemRepo.save(item);
            return "Item saved successfully";
        }else{
            throw new RuntimeException("Item save failed");
        }
    }

    @Override
    public List<ItemGetResponseDTO> getItemByNameAndStatus(String itemName) {
        List<Item> items = itemRepo.findAllByItemNameEqualsAndActiveEquals(itemName,true);

        if(!items.isEmpty()){
            List<ItemGetResponseDTO> itemGetResponseDTOS = modelMapper.map(items,new TypeToken<List<ItemGetResponseDTO>>(){}.getType());
            return itemGetResponseDTOS;
        }else {
            throw new RuntimeException("Item not find");
        }
    }

    @Override
    public List<ItemGetResponseDTO> getItemByNameAndStatusByMapstruct(String itemName) {
        List<Item> items = itemRepo.findAllByItemNameEqualsAndActiveEquals(itemName,true);

        if(!items.isEmpty()){
            List<ItemGetResponseDTO> itemGetResponseDTOS = itemMapper.entityListToDtoList(items);//util eke thiyena interface eke badu theenne
            return itemGetResponseDTOS;
        }else {
            throw new RuntimeException("Item not find");
        }
    }

    @Override
    public List<ItemGetResponseDTO> getItemsByActiveStatus(boolean activeStatus) {
        List<Item> items = itemRepo.findAllByActiveEquals(activeStatus);

        if(!items.isEmpty()){
            List<ItemGetResponseDTO> itemGetResponseDTOS = modelMapper.map(items,new TypeToken<List<ItemGetResponseDTO>>(){}.getType());
            return itemGetResponseDTOS;
        }else {
            throw new NotFoundException("no items to match your active status");
        }
    }

    @Override
    public PaginatedResponseItemDTO getItemsByActiveStatusWithPagination(boolean activeStatus, int page, @Max(50) int size) {
        Page<Item> item = itemRepo.findAllByActiveEquals(activeStatus,PageRequest.of(page,size));
        if(item.isEmpty()){
            throw new NotFoundException("no items to match your active status");
        }
        PaginatedResponseItemDTO paginatedResponseDTO = new PaginatedResponseItemDTO(itemMapper.ListDTOToPage(item), itemRepo.countAllByActiveEquals(activeStatus));

        return  paginatedResponseDTO;
    }
}
