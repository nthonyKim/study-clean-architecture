package com.study.coupon.coupon.application.service;

import com.study.coupon.common.application.SecurityUtils;
import com.study.coupon.coupon.application.port.out.LoadCouponPort;
import com.study.coupon.coupon.application.port.out.UpdateCouponPort;
import com.study.coupon.coupon.domain.Coupon;
import com.study.coupon.coupon.application.port.in.RegisterCouponUseCase;
import com.study.coupon.coupon.application.port.in.command.RegisterCouponCommand;
import com.study.coupon.point.application.port.in.CompletePointUseCase;
import com.study.coupon.point.domain.Point;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class RegisterCouponService implements RegisterCouponUseCase {

    private final UpdateCouponPort updateCouponPort;
    private final LoadCouponPort loadCouponPort;
    private final CompletePointUseCase completePointUseCase;

    @Override
    @Transactional
    public void register(RegisterCouponCommand command) {
        Coupon coupon = loadCouponPort.byCode(command.getCode()).orElseThrow(() -> new RuntimeException("쿠폰이 존재하지 않음 (커스텀 예외 클래스 필요)"));
        validate(coupon);

        coupon.registered();
        updateCouponPort.save(coupon);

        Long userId = SecurityUtils.getCurrentUserId();
        switch (coupon.getType()) {
            case POINT -> {
                Point point = Point.byCoupon(userId, coupon.getPoint());
                completePointUseCase.complete(point);
            }
            case MONTHLY -> {
                // TODO 이용권
            }
        }
    }

    @Override
    public void validate(Coupon coupon) {
        if (!coupon.useAvailable()) {
            // TODO throw
        }
    }
}
