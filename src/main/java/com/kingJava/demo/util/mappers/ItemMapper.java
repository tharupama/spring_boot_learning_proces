package com.kingJava.demo.util.mappers;

import com.kingJava.demo.dto.response.ItemGetResponseDTO;
import com.kingJava.demo.entity.Item;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    List<ItemGetResponseDTO> entityListToDtoList(List<Item> items);//kanapita yanne

    List<ItemGetResponseDTO> ListDTOToPage(Page<Item> item);
}
