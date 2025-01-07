package kr.hhplus.be.server.dto.request;


public record ProductRequest(
        Long productId,
        Integer productPrice,
        Integer productQuantity
) {
}
