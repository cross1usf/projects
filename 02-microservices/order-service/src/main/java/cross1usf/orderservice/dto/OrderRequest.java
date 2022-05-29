package cross1usf.orderservice.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class OrderRequest {

    private List<OrderItemsDto> orderItemsDtoList;


}
