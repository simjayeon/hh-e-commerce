package kr.hhplus.be.server.dto.response;


import kr.hhplus.be.server.entity.Product;
import lombok.Builder;

@Builder
public record ProductResponse(
        Long productId,
        String productName,
        Integer productPrice,
        Integer productQuantity
) {
    public static ProductResponse of(Product product) {
        return ProductResponse.builder()
                .productId(product.getId())
                .productName(product.getName())
                .productPrice(product.getPrice())
                .productQuantity(product.getQuantity())
                .build();
    }
}
