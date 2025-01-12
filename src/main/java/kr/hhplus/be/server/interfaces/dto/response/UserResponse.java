package kr.hhplus.be.server.interfaces.dto.response;


public record UserResponse(
        Long userId,
        String userName,
        Integer email,
        Integer productQuantity
) {
}
