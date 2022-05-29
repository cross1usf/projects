package cross1usf.productservice.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class ProductRequest {

    private String name;
    private String description;
    private BigDecimal price;

}
