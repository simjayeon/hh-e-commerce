package kr.hhplus.be.server.support.exception;

public class InterruptedException extends RuntimeException {
    // 기본 생성자
    public InterruptedException() {
        super();
    }

    // 상세 메시지를 전달하는 생성자
    public InterruptedException(String message) {
        super(message);
    }

    // 상세 메시지와 원인 예외를 전달하는 생성자
    public InterruptedException(String message, Throwable cause) {
        super(message, cause);
    }

    // 원인 예외만 전달하는 생성자
    public InterruptedException(Throwable cause) {
        super(cause);
    }
}
