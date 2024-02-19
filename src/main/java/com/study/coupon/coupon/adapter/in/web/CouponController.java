package com.study.coupon.coupon.adapter.in.web;

import com.study.coupon.coupon.port.in.command.GenerateCouponCommand;
import com.study.coupon.coupon.port.in.GenerateCouponUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1/coupon")
@RequiredArgsConstructor
public class CouponController {

    private final GenerateCouponUseCase generateCoupon;

    @PostMapping
    String generateCoupon(@Valid @RequestBody GenerateCouponCommand command) {
        return generateCoupon.generate(command);
    }
}
