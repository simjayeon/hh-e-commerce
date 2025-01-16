package kr.hhplus.be.server.interfaces.dto.response;


public record UserResponse(
        Long userId,
        String name,
        Integer email,
        String password
) {
}
