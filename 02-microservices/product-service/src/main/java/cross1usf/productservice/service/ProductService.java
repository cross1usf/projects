package cross1usf.productservice.service;

import cross1usf.productservice.dto.ProductRequest;
import cross1usf.productservice.dto.ProductResponse;
import cross1usf.productservice.mappers.ProductMapper;
import cross1usf.productservice.model.Product;
import cross1usf.productservice.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest) {
        var productMapper = new ProductMapper();
        productRepository.save(productMapper.map(productRequest));
        log.info("Product {} is saved", productRequest.getName());
    }


    public List<ProductResponse> getAllProducts() {
       List<Product> products=  productRepository.findAll();
       var productMapper = new ProductMapper();
      return products.stream().map(product -> productMapper.productResponse(product)).toList();

    }
}
