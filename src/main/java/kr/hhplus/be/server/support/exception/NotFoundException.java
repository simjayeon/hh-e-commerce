package kr.hhplus.be.server.support.exception;

public class NotFoundException extends RuntimeException {
    // 기본 생성자
    public NotFoundException() {
        super();
    }

    // 상세 메시지를 전달하는 생성자
    public NotFoundException(String message) {
        super(message);
    }

    // 상세 메시지와 원인 예외를 전달하는 생성자
    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    // 원인 예외만 전달하는 생성자
    public NotFoundException(Throwable cause) {
        super(cause);
    }
}
