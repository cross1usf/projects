package cross1usf.inventoryservice.service;

import cross1usf.inventoryservice.dto.InventoryResponse;
import cross1usf.inventoryservice.model.Inventory;
import cross1usf.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {

    private final InventoryRepository inventoryRepository;


    public Integer getInventory(String sku) {
        Inventory inventory = inventoryRepository.findBySkuCode(sku).orElseThrow(() -> new RuntimeException("Item not Found."));
        return inventory.getQuantityOnHand();

    }

    @Transactional
    public List<InventoryResponse> inStock(List<String> skuCode) {
        System.out.println(skuCode);
       return inventoryRepository.findBySkuCodeIn(skuCode).orElseThrow( () -> new RuntimeException("Item not found!"))
               .stream()
               .map(inventory ->
                   InventoryResponse.builder()
                   .skuCode(inventory.getSkuCode())
                   .isInStock(inventory.getQuantityOnHand() > 0)
                   .build()).toList();


    }

    public Date getShipmentDate(String skuCode) {
        return inventoryRepository.findBySkuCode(skuCode).get().getNextShipment();
    }
}
