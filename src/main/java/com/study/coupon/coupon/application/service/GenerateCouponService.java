package com.study.coupon.coupon.application.service;

import com.study.coupon.coupon.application.port.out.UpdateCouponPort;
import com.study.coupon.coupon.domain.Coupon;
import com.study.coupon.coupon.application.port.in.command.GenerateCouponCommand;
import com.study.coupon.coupon.application.port.in.GenerateCouponUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class GenerateCouponService implements GenerateCouponUseCase {

    private final UpdateCouponPort updateCouponPort;

    @Override
    public String generate(GenerateCouponCommand command) {
        Coupon coupon = Coupon.generate(command.getPoint(), command.getType());
        updateCouponPort.save(coupon);
        return coupon.getCode();
    }
}
