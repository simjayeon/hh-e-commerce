package kr.hhplus.be.server.dto.request;


import java.util.List;

public record OrderRequest(
        Long userId,
        List<ProductRequest> products
) {
}
