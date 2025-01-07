package kr.hhplus.be.server.dto.response;


public record ProductResponse(
        Long productId,
        String productName,
        Integer productPrice,
        Integer productQuantity
) {
}
