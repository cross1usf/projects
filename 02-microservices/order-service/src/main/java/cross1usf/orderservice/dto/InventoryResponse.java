package cross1usf.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InventoryResponse {

    private String skuCode;
    private boolean isInStock;
    private String notBadf;
    private String isThisGonnaWork;
    private String thisIsTheMove;
    private String itIsWorking;

}