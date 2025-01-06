package kr.hhplus.be.server.domains.controller;

import kr.hhplus.be.server.domains.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final CouponService couponService;

}
