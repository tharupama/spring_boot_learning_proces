package com.kingJava.demo.service;

import com.kingJava.demo.dto.paginated.PaginatedResponseItemDTO;
import com.kingJava.demo.dto.request.ItemSaveRequestDTO;
import com.kingJava.demo.dto.response.ItemGetResponseDTO;

import java.util.List;

public interface ItemService {
    String saveItem(ItemSaveRequestDTO item);

    List<ItemGetResponseDTO> getItemByNameAndStatus(String itemName);

    List<ItemGetResponseDTO> getItemByNameAndStatusByMapstruct(String itemName);

    List<ItemGetResponseDTO> getItemsByActiveStatus(boolean activeStatus);

    PaginatedResponseItemDTO getItemsByActiveStatusWithPagination(boolean activeStatus, int page, int size);
}
