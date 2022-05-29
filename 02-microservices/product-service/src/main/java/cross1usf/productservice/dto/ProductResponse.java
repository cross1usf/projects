package cross1usf.productservice.dto;

import lombok.*;

import javax.persistence.Id;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {


    private String name;
    private String description;
    private BigDecimal price;
}
