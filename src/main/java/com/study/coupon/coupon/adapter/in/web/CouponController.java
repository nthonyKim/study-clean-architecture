package com.study.coupon.coupon.adapter.in.web;

import com.study.coupon.coupon.port.in.RegisterCouponUseCase;
import com.study.coupon.coupon.port.in.command.GenerateCouponCommand;
import com.study.coupon.coupon.port.in.GenerateCouponUseCase;
import com.study.coupon.coupon.port.in.command.RegisterCouponCommand;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1/coupon")
@RequiredArgsConstructor
public class CouponController {

    private final GenerateCouponUseCase generateCoupon;
    private final RegisterCouponUseCase registerCoupon;

    @PostMapping("/generate")
    ResponseEntity<String> generateCoupon(@Valid @RequestBody GenerateCouponCommand command) {
        return ResponseEntity.ok(generateCoupon.generate(command));
    }

    @PostMapping("/register")
    ResponseEntity<Void> registerCoupon(@Valid @RequestBody RegisterCouponCommand command) {
        registerCoupon.register(command);
        return ResponseEntity.ok().build();
    }
}
