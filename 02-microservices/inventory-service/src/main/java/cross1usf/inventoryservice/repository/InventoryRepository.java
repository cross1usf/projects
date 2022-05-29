package cross1usf.inventoryservice.repository;

import cross1usf.inventoryservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

    Optional <Inventory> findBySkuCode(String skuCode);
    Optional <List<Inventory>> findBySkuCodeIn(List<String> skuCode);
}
