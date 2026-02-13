package com.kingJava.demo.dto.paginated;

import com.kingJava.demo.dto.request.RequestOrderDetailsSaveDTO;
import com.kingJava.demo.dto.response.ResponseOrderDetailsDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data

public class PaginatedResponseOrderDetails {
    private List<ResponseOrderDetailsDTO> list;
    private long dtaCount;
}
