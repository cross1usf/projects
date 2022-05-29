package cross1usf.productservice.mappers;

import cross1usf.productservice.dto.ProductRequest;
import cross1usf.productservice.dto.ProductResponse;
import cross1usf.productservice.model.Product;


public class ProductMapper {

    public Product map(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        return product;
    }

    public ProductResponse productResponse(Product product) {
        ProductResponse productResponse = ProductResponse.builder()
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();

        return productResponse;
    }


}
