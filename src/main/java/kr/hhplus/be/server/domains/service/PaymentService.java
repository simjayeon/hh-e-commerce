package kr.hhplus.be.server.domains.service;

import kr.hhplus.be.server.dto.request.OrderRequest;
import kr.hhplus.be.server.dto.response.OrderResponse;
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
