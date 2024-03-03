package com.study.coupon.coupon.application.service;

import com.study.coupon.coupon.application.port.out.LoadCouponPort;
import com.study.coupon.coupon.application.port.out.UpdateCouponPort;
import com.study.coupon.coupon.domain.Coupon;
import com.study.coupon.coupon.application.port.in.RegisterCouponUseCase;
import com.study.coupon.coupon.application.port.in.command.RegisterCouponCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class RegisterCouponService implements RegisterCouponUseCase {

    private final UpdateCouponPort updateCouponPort;
    private final LoadCouponPort loadCouponPort;

    @Override
    public void register(RegisterCouponCommand command) {
        Coupon coupon = loadCouponPort.byCode(command.getCode()).orElseThrow(() -> new RuntimeException("쿠폰이 존재하지 않음 (커스텀 예외 클래스 필요)"));
        validate(coupon);

        coupon.registered();
        updateCouponPort.save(coupon);
    }

    @Override
    public void validate(Coupon coupon) {
        if (!coupon.useAvailable()) {
            // TODO throw
        }
    }
}
