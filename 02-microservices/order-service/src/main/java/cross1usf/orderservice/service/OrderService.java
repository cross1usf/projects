package cross1usf.orderservice.service;

import cross1usf.orderservice.client.InventoryClient;
import cross1usf.orderservice.dto.InventoryResponse;
import cross1usf.orderservice.dto.OrderItemsDto;
import cross1usf.orderservice.dto.OrderRequest;
import cross1usf.orderservice.mappers.OrderMapper;
import cross1usf.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreaker;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;
    private final Resilience4JCircuitBreakerFactory circuitBreakerFactory;

    @Transactional
    public String placeOrder(OrderRequest orderRequest) {
        Resilience4JCircuitBreaker circuitBreaker = circuitBreakerFactory.create("inventory");
        OrderMapper orderMapper = new OrderMapper();
        List<String> skuCodes = orderRequest.getOrderItemsDtoList().stream().map(OrderItemsDto::getSkuCode).toList();
        Supplier<Boolean> productSupplier = () -> inventoryClient.isInStock(skuCodes).stream().allMatch(InventoryResponse::isInStock);
        boolean productsInStock = circuitBreaker.run(productSupplier, throwable -> false);
        System.out.println(productsInStock);
        if (productsInStock) {
            orderRepository.save(orderMapper.map(orderRequest));
            return "Order Placed";
        } else
            return "Order Failed";

    }

}

