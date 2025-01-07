package kr.hhplus.be.server.dto.response;


public record UserResponse(
        Long userId,
        String userName,
        Integer email,
        Integer productQuantity
) {
}
