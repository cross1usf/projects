package cross1usf.orderservice.mappers;

import cross1usf.orderservice.dto.OrderItemsDto;
import cross1usf.orderservice.dto.OrderRequest;
import cross1usf.orderservice.model.Order;
import cross1usf.orderservice.model.OrderItems;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;
import java.util.UUID;


public class OrderMapper {


    public Order map(OrderRequest orderRequest) {
        Order order = Order.builder()
                .orderNumber(UUID.randomUUID().toString())
                .date(Instant.now())
                .orderItemsList(orderRequest.getOrderItemsDtoList().stream().map(this::mapItems).toList())
                .build();
        return order;
    }


    public OrderItems mapItems(OrderItemsDto orderItemsDto) {
        OrderItems orderItems = OrderItems.builder()
                .price(orderItemsDto.getPrice())
                .quantity(orderItemsDto.getQuantity())
                .skuCode(orderItemsDto.getSkuCode())
                .build();
        return orderItems;
    }

}
