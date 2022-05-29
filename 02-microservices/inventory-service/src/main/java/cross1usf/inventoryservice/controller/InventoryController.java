package cross1usf.inventoryservice.controller;

import cross1usf.inventoryservice.dto.InventoryResponse;
import cross1usf.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;


    @GetMapping("/quantity")
    public Integer getQuantity(String sku) {
        return inventoryService.getInventory(sku);
    }


    @GetMapping
    public List<InventoryResponse> inStock(@RequestParam List <String> skuCode) {
        System.out.println("MADE IT TO INVENTORY CONTROLLER");
        return inventoryService.inStock(skuCode);
    }

    @GetMapping("/nextshipment")
    public Date getShipment(String skuCode) {
        return inventoryService.getShipmentDate(skuCode);
    }
}




