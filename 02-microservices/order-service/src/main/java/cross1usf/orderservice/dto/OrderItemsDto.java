package cross1usf.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemsDto {


    private String skuCode;
    private Integer price;

    private Integer quantity;
}
