package kr.hhplus.be.server.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    public ResponseEntity<Boolean> executePayment() {
        return null;
    }

}
