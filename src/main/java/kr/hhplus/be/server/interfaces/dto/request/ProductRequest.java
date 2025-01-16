package kr.hhplus.be.server.interfaces.dto.request;


public record ProductRequest(
        Long productId,
        Integer productQuantity
) {
}
