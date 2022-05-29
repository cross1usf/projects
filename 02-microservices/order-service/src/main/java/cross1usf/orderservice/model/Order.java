package cross1usf.orderservice.model;

import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String orderNumber;
    private Instant date;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItems> orderItemsList;


}
