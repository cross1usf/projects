package cross1usf.orderservice.controller;

import cross1usf.orderservice.client.InventoryClient;
import cross1usf.orderservice.dto.OrderRequest;
import cross1usf.orderservice.service.OrderService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;


@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @CircuitBreaker(name = "inventory-service",fallbackMethod = "fallback")
    @TimeLimiter(name = "inventory")
    public CompletableFuture<String> placeOrder(@RequestBody OrderRequest orderRequest) {
       return CompletableFuture.supplyAsync(() -> orderService.placeOrder(orderRequest));

    }


    public CompletableFuture<String> fallback(OrderRequest orderRequest, RuntimeException runtimeException){
        return CompletableFuture.supplyAsync(() -> "Looks like something went wrong, please try again");
    }
}

